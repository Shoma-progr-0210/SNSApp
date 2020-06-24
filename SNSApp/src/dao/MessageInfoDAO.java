package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import entity.MessageEntity;
import util.DBAccessException;
import util.ErrorCodeConstValue;

/**
 * メッセージ情報テーブルにアクセスするDAO
 *
 * @author shoma
 *
 */
public class MessageInfoDAO {

    /**
     * メッセージをDBに登録するメソッド
     *
     * @param userNo
     * @param message
     * @return
     * @throws DBAccessException
     */
    public boolean insertMessageInfo(String userNo,String message) throws DBAccessException{

        String sql = "insert into message_info(USER_NO, MESSAGE, DEL_FLG, CREATE_DT, UPDATE_DT) "
                + "values( ?, ?, 0, LOCALTIMESTAMP(), LOCALTIMESTAMP())";


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

    /**
     * タイムラインに表示するメッセージを取得するメソッド
     *
     * @return
     * @throws DBAccessException
     */
    public ArrayList<MessageEntity> selectAllMessageInfo() throws DBAccessException {

        //メッセージオブジェクトリストを生成
        ArrayList<MessageEntity> messageEntityList = new ArrayList<MessageEntity>();

        String sql = "SELECT * FROM MESSAGE_INFO;";

        //データソースを取得
        DataSource ds = DataSourceSupplier.getDataSource();

        try(Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){

            //SQL実行
            try (ResultSet rs = ps.executeQuery()){

                //UserEntityオブジェクトに値をセット
                while (rs.next()) {
                    //メッセージオブジェクトを生成
                    MessageEntity messageEntity = new MessageEntity();

                    //DBから取得したメッセージ情報をセット
                    messageEntity.setUserNo(rs.getString("USER_NO"));
                    messageEntity.setMsgNo(rs.getString("MSG_NO"));
                    messageEntity.setMessage(rs.getString("MESSAGE"));
                    messageEntity.setDelFlag(rs.getBoolean("DEL_FLG"));
                    messageEntity.setCreateDT(rs.getTimestamp("CREATE_DT"));
                    messageEntity.setUpdateDT(rs.getTimestamp("UPDATE_DT"));

                    //メッセージオブジェクトをリストに追加
                    messageEntityList.add(messageEntity);
                }
            }
        }catch (SQLException e) {
            throw new DBAccessException(ErrorCodeConstValue.DB_ERR);
        }
        return messageEntityList;
    }

}
