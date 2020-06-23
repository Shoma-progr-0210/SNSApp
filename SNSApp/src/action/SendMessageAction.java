package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.UserAccountEntity;
import service.PerformanceService;
import util.DBAccessException;
import util.DataInconsistencyException;
import util.ErrorCodeConstValue;
import util.ParamCheckException;

public class SendMessageAction extends PerformanceAction {

    private final PerformanceService PerService = new PerformanceService();

    @Override
    protected String processPerformanceManagement(HttpServletRequest request)
            throws ParamCheckException, DBAccessException, DataInconsistencyException {

        //セッション継続
        HttpSession session =  request.getSession(false);

        //セッションからユーザログイン情報を取得
        UserAccountEntity userAccountEntity = (UserAccountEntity) session.getAttribute("userAccountEntity");

        //ログイン情報からユーザIDを取得
        String userNo = userAccountEntity.getUserNo();
        //リクエストからメッセージを取得
        String message = request.getParameter("message");

        //メッセージが送信出来なかった場合、エラーをスロー
        if (!PerService.insertMessageInfo(userNo, message)) {
            throw new DataInconsistencyException(ErrorCodeConstValue.SEND_MESSAGE_ERR);
        }

        return "/jsp/sendMsgResult.jsp";
    }

}
