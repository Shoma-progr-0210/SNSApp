package action;

import javax.servlet.http.HttpServletRequest;

import util.DBAccessException;
import util.DataInconsistencyException;
import util.ParamCheckException;
import util.SessionDisconnectionException;

public class SettingAction extends Action {

    @Override
    protected String processRequest(HttpServletRequest request)
            throws ParamCheckException, DBAccessException, DataInconsistencyException, SessionDisconnectionException {

        //セッション継続
        request.getSession(false);

        return "/jsp/setting.jsp";
    }

}
