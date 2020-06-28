package service;

import java.util.ArrayList;

import dao.MessageInfoDAO;
import dao.UserInfoDAO;
import entity.MessageEntity;
import entity.UserAccountEntity;
import util.DBAccessException;
import util.ParamCheckException;
import util.PerformanceValidator;

public class PerformanceService {

    private final MessageInfoDAO msgDao = new MessageInfoDAO();
    private final UserInfoDAO userInfoDao = new UserInfoDAO();

    /**
     * メッセージ送信のDAOにアクセスするメソッド
     *
     * @param userNo
     * @param message
     * @return
     * @throws DBAccessException
     * @throws ParamCheckException
     */
    public boolean insertMessageInfo(String userNo, String message) throws DBAccessException, ParamCheckException{
        //メッセージのチェック
        PerformanceValidator.checkMessage(message);

        return msgDao.insertMessageInfo(userNo, message);
    }

    /**
     * ユーザIDをキーにユーザのアカウント情報を取得するDAOにアクセスするメソッド
     *
     * @param userId
     * @return
     * @throws DBAccessException
     * @throws ParamCheckException
     */
    public UserAccountEntity userInfo(String userId) throws DBAccessException, ParamCheckException{

        return userInfoDao.getUserInfoByUserId(userId);
    }

    /**
     * タイムラインに表示するメッセージを全件取得するDAOにアクセスするメソッド
     *
     * @return
     * @throws DBAccessException
     * @throws ParamCheckException
     */
    public ArrayList<MessageEntity> selectAllMessageInfo() throws DBAccessException, ParamCheckException{

        return msgDao.selectAllMessageInfo();
    }

    /**
     * ユーザアカウント情報を変更するDAOにアクセスするメソッド
     *
     * @param updateUserAccountEntity
     * @return
     * @throws DBAccessException
     * @throws ParamCheckException
     */
    public boolean updateUserInfo(UserAccountEntity updateUserAccountEntity) throws DBAccessException, ParamCheckException {

        return userInfoDao.updateUserInfo(updateUserAccountEntity);
    }
}
