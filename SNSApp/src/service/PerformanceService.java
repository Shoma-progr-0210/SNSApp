package service;

import dao.MessageInfoDAO;
import entity.UserAccountEntity;
import util.DBAccessException;
import util.ParamCheckException;
import util.PerformanceValidator;

public class PerformanceService {

    private final MessageInfoDAO msgDao = new MessageInfoDAO();
    private final UserInfoDAO userInfoDao = new UserInfoDAO();


    public boolean insertMessageInfo(String userNo, String message) throws DBAccessException, ParamCheckException{
        //メッセージのチェック
        PerformanceValidator.checkMessage(message);

        return msgDao.insertMessageInfo(userNo, message);
    }

    public UserAccountEntity userInfo(String userId) throws DBAccessException, ParamCheckException{

        return userInfoDao.getUserInfoByUserId(userId);
    }

}
