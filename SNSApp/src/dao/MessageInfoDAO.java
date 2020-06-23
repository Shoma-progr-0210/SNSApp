package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import util.DBAccessException;
import util.ErrorCodeConstValue;

public class MessageInfoDAO {

    public boolean insertMessageInfo(String userNo,String message) throws DBAccessException{

        //int insert = 0;//実行件数カウンタ

        String sql = "insert into message_info(USER_NO, MESSAGE, DEL_FLG, CREATE_DT, UPDATE_DT) "
                + "values( ?, ?, 0, "
                +LocalDateTime.now()
                +", "
                +LocalDateTime.now();


        //データソースを取得
        DataSource ds = DataSourceSupplier.getDataSource();

        try(Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){

            //SQL文のプレースホルダに値をセット
            ps.setString(1, userNo);
            ps.setString(2, message);

            //SQL実行
            int insert = ps.executeUpdate();

            //SQLの実行結果件数が1以外の場合、falseを返却
            if (insert != 1) {
                //対象がない場合、処理を中断
                return false;
            }
        } catch (SQLException e) {
            throw new DBAccessException(ErrorCodeConstValue.DB_ERR);
        }
        return true;
    }

}
