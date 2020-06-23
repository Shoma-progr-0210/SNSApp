package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.MessageEntity;
import entity.UserAccountEntity;
import util.DBAccessException;
import util.DataInconsistencyException;
import util.ParamCheckException;

public class SendMessageAction extends PerformanceAction {

    @Override
    protected String processPerformanceManagement(HttpServletRequest request)
            throws ParamCheckException, DBAccessException, DataInconsistencyException {

        //セッション継続
        HttpSession session =  request.getSession(false);


        //メッセージ情報オブジェクトを生成
        MessageEntity messageEntity = new MessageEntity();
        //ユーザー情報オブジェクトを生成
        UserAccountEntity userAccountEntity = new UserAccountEntity();


        //リクエストからメッセージを取得
        String message = request.getParameter("message");


        return null;
    }

}
