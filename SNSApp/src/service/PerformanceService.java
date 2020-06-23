package service;

import util.DBAccessException;
import util.ParamCheckException;
import util.PerformanceValidator;

public class PerformanceService {

    private final MessageInfoDAO msgDao = new MessageInfoDAO();


    public boolean insertMessageInfo(String userId, String message) throws DBAccessException, ParamCheckException{
        //メッセージのチェック
        PerformanceValidator.checkMessage(message);

        return msgDao.insertMessageInfo(userId, message);
    }

}
