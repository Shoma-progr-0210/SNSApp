package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import util.DBAccessException;
import util.ErrorCodeConstValue;

/**
 * エラー情報テーブルへアクセスを行うクラス
 * @author shoma
 *
 */
public class ErrorInfoDAO {

    /**
     * エラーコードをキーに、エラー情報テーブルからエラーメッセージを取得するメソッド
     * @param errorCode
     * @return
     * @throws DBAccessException
     */
    public String getErrorMsgByErrorCode(String errorCode) throws DBAccessException {

        String errorMsg = "";

        //ユーザを検索するSQL
        String sql = "SELECT ERROR_WORDS FROM ERROR_INFO WHERE ERROR_CD = ?";

        //データソースを取得
        DataSource ds = DataSourceSupplier.getDataSource();

        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){

            //SQL文のプレースホルダに値をセット
            ps.setString(1, errorCode);

            //SQL文実行
            try (ResultSet rs = ps.executeQuery()){

                //ResultSetのカーソルを一行進める
                if(!rs.next()) {
                    //対象がない場合は処理を中断
                    return null;
                }

                //UserEntityオブジェクトを作成して、値をセット
                errorMsg = rs.getString("ERROR_WORDS");

            }
        } catch (SQLException e) {
            throw new DBAccessException(ErrorCodeConstValue.DB_ERR);
        }
        return errorMsg;
    }

}
