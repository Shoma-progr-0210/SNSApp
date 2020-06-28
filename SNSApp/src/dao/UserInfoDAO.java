package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import entity.UserAccountEntity;
import util.DBAccessException;
import util.ErrorCodeConstValue;

public class UserInfoDAO {

    /**
     * ユーザアカウント情報をユーザIDをキーに取得するメソッド
     *
     * @param userId
     * @return
     * @throws DBAccessException
     */
    public UserAccountEntity getUserInfoByUserId(String userId) throws DBAccessException {

        //UserEntityオブジェクトを作成
        UserAccountEntity userAccountEntity = new UserAccountEntity();

        //ユーザを検索するSQL
        String sql = "SELECT * "
                + " FROM USER_INFO"
                + " WHERE USER_NO = ?";

        //データソースを取得
        DataSource ds = DataSourceSupplier.getDataSource();

        try(Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){

            //SQL文のプレースホルダに値をセット
            ps.setString(1, userId);

            //SQL文を実行
            try (ResultSet rs = ps.executeQuery()){

                //ResultSetのカーソルを1行進める
                if (!rs.next()) {
                    //対象がない場合、処理を中断
                    return null;
                }

                //UserEntityオブジェクトに値をセット
                userAccountEntity.setUserNo(rs.getString("USER_NO"));
                userAccountEntity.setFamilyName(rs.getString("FAMILY_NAME"));
                userAccountEntity.setFirstName(rs.getString("FIRST_NAME"));
                userAccountEntity.setBirthday(rs.getString("BIRTHDAY"));
                userAccountEntity.setChatName(rs.getString("CHAT_NAME"));
            }
        }catch (SQLException e) {
            throw new DBAccessException(ErrorCodeConstValue.DB_ERR);
        }
        return userAccountEntity;
    }

    /**
     * ユーザアカウント情報をアップデートするメソッド
     *
     * @param updateUserAccountEntity
     * @return
     * @throws DBAccessException
     */
    public boolean updateUserInfo(UserAccountEntity updateUserAccountEntity) throws DBAccessException {

        //ユーザアカウント情報をアップデートするSQL
        String sql = " update user_info " +
                "set FAMILY_NAME = ?, FIRST_NAME = ?, BIRTHDAY = ?, CHAT_NAME = ?" +
                " where user_no = ?;";

        //データソースを取得
        DataSource ds = DataSourceSupplier.getDataSource();

        try(Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){

            //SQL文のプレースホルダに値をセット
            ps.setString(1, updateUserAccountEntity.getFamilyName());
            ps.setString(2, updateUserAccountEntity.getFirstName());
            ps.setString(3, updateUserAccountEntity.getBirthday());
            ps.setString(4, updateUserAccountEntity.getChatName());
            ps.setString(5, updateUserAccountEntity.getUserNo());

            //SQL文を実行
            int updateCount = ps.executeUpdate();

            if (updateCount != 1) {
                return false;
            }

        }catch (SQLException e) {
            throw new DBAccessException(ErrorCodeConstValue.DB_ERR);
        }
        return true;
    }

}
