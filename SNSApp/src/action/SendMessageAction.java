package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.UserEntity;
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
        UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");

        //ログイン情報からユーザIDを取得
        String userId = userEntity.getUserId();
        //リクエストからメッセージを取得
        String message = request.getParameter("message");

        //メッセージが送信出来なかった場合、エラーをスロー
        if (!PerService.insertMessageInfo(userId, message)) {
            throw new DataInconsistencyException(ErrorCodeConstValue.SEND_MESSAGE_ERR);
        }

        return "/jsp/sendMsgResult.jsp";
    }

}
