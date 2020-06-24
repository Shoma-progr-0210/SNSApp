package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.UserAccountEntity;
import entity.UserEntity;
import service.LoginService;
import service.PerformanceService;
import util.DBAccessException;
import util.DataInconsistencyException;
import util.ErrorCodeConstValue;
import util.ParamCheckException;
import util.SessionDisconnectionException;

public class LoginAction extends Action {

    private final LoginService logService = new LoginService();
    private final PerformanceService PerService = new PerformanceService();

    @Override
    protected String processRequest(HttpServletRequest request)
            throws ParamCheckException, DBAccessException, DataInconsistencyException, SessionDisconnectionException {

        String userId = request.getParameter("userId");
        String password = request.getParameter("pass");

        String url = "/jsp/error.jsp";

        //ユーザマスタより、入力されたユーザ名とパスワードに該当するユーザ情報を取得
        UserEntity userEntity = logService.login(userId, password);

        //該当するユーザが存在しない場合、エラーメッセージをスロー
        if (userEntity == null) {
            throw new DataInconsistencyException(ErrorCodeConstValue.LOGIN_ERR);

        //必要な情報をセッションに格納してタイムラインに遷移
        }else {

            //セッション開始
            HttpSession session = request.getSession(true);

            //ユーザアカウント情報を取得
            UserAccountEntity userAccountEntity = PerService.userInfo(userId);

            //ユーザログイン情報をセッションに設定
            session.setAttribute("userEntity", userEntity);
            //ユーザアカウント情報をセッションに設定
            session.setAttribute("userAccountEntity", userAccountEntity);

            //遷移先URLを返す
            url = "/jsp/welcome.jsp";
        }
        // TODO 自動生成されたメソッド・スタブ
        return url;
    }

}
