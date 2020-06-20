package action;

import javax.servlet.http.HttpServletRequest;

import service.ErrorService;
import util.DBAccessException;
import util.DataInconsistencyException;
import util.ErrorCodeConstValue;
import util.ParamCheckException;
import util.SessionDisconnectionException;

public abstract class Action {

    protected String errorMsg = "";

    protected ErrorService errService = new ErrorService();

    public String execute(HttpServletRequest request) {
        try {
            //リクエストに対する各アクションの個別処理
            return processRequest(request);

        } catch (ParamCheckException | DBAccessException | DataInconsistencyException
                | SessionDisconnectionException e) {
            try {
                if (e.getErrCD() != null) {
                    //エラーメッセージを取得
                    errorMsg = errService.getErrorMsgByErrorCode(e.getErrCD());

                    //エラーメッセージを取得出来なかった場合、直接メッセージを渡す
                    if (errorMsg.isEmpty()) {
                        errorMsg = ErrorCodeConstValue.UNEXPECTED_ERR;
                    }
                } else {
                    //例外のスタックトレース出力
                    e.printStackTrace();
                }
            } catch (DBAccessException e1) {
                //エラーメッセージを取得時にエラーが発生した場合は、直接メッセージを渡す
                errorMsg = ErrorCodeConstValue.UNEXPECTED_ERR;
                request.setAttribute("errorMsg", errorMsg);

                //ログイン時とそれ以外で遷移先を変更
                if ("login".equals(request.getParameter("action_name"))){
                    //ログイン時の想定外エラー
                    return "/jsp/loginError.jsp";
                } else {
                    //それ以外の機能での想定外エラー
                    return "/jsp/error.jsp";
                }
            }
            request.setAttribute("errorMsg", errorMsg);

            //ログイン時とそれ以外で遷移先を変更
            if ("login".equals(request.getParameter("action_name"))){
                //ログイン時の想定外エラー
                return "/jsp/loginError.jsp";
            } else {
                //それ以外の機能での想定外エラー
                return "/jsp/error.jsp";
            }
        }

    }

    protected abstract String processRequest(HttpServletRequest request)
            throws ParamCheckException, DBAccessException, DataInconsistencyException
            , SessionDisconnectionException;

}
