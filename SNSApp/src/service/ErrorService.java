package service;

import dao.ErrorInfoDAO;
import util.DBAccessException;

public class ErrorService {

    private final ErrorInfoDAO errDao = new ErrorInfoDAO();

    public String getErrorMsgByErrorCode(String errorCode) throws DBAccessException {
        return errDao.getErrorMsgByErrorCode(errorCode);

    }

}
