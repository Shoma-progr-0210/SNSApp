package action;

import javax.servlet.http.HttpServletRequest;

import util.DBAccessException;
import util.DataInconsistencyException;
import util.ErrorCodeConstValue;
import util.LoginValidator;
import util.ParamCheckException;
import util.SessionDisconnectionException;

public abstract class PerformanceAction extends Action {

    @Override
    protected String processRequest(HttpServletRequest request)
            throws ParamCheckException, DBAccessException, DataInconsistencyException, SessionDisconnectionException {
        if(!LoginValidator.checkSession(request)) {
            //ログイン済みでなければ、セッションを破棄してエラーページに遷移
            throw new SessionDisconnectionException(ErrorCodeConstValue.SESSION_DISCONNECT_ERR);
        }
        return processPerformanceManagement(request);
    }




    protected abstract String processPerformanceManagement(HttpServletRequest request)
            throws ParamCheckException, DBAccessException, DataInconsistencyException;

}
