package action;

import javax.servlet.http.HttpServletRequest;

import util.DBAccessException;
import util.DataInconsistencyException;
import util.ParamCheckException;

public class MessageAction extends PerformanceAction {

    @Override
    protected String processPerformanceManagement(HttpServletRequest request)
            throws ParamCheckException, DBAccessException, DataInconsistencyException {

        //セッション継続
        request.getSession(false);

        return "/jsp/message.jsp";
    }

}
