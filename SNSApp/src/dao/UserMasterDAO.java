package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import entity.UserEntity;
import util.DBAccessException;
import util.ErrorCodeConstValue;

public class UserMasterDAO {

    public UserEntity findByCredential(String userId, String password) throws DBAccessException {

        //UserEntityオブジェクトを作成
        UserEntity userEntity = new UserEntity();

        //ユーザを検索するSQL
        String sql = "SELECT USER_ID, PASSWORD"
                + " FROM USER_MASTER"
                + " WHERE USER_ID = ?"
                + " AND PASSWORD = ?";

        //データソースを取得
        DataSource ds = DataSourceSupplier.getDataSource();

        try(Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){

            //SQL文のプレースホルダに値をセット
            ps.setString(1, userId);
            ps.setString(2, password);

            //SQL文を実行
            try (ResultSet rs = ps.executeQuery()){

                //ResultSetのカーソルを1行進める
                if (!rs.next()) {
                    //対象がない場合、処理を中断
                    return null;
                }

                //UserEntityオブジェクトに値をセット
                userEntity.setUserId(rs.getString("USER_ID"));
                userEntity.setPassword(rs.getString("PASSWORD"));
            }
        }catch (SQLException e) {
            throw new DBAccessException(ErrorCodeConstValue.DB_ERR);
        }
        return userEntity;
    }

}
