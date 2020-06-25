package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import entity.MessageEntity;
import service.PerformanceService;
import util.DBAccessException;
import util.DataInconsistencyException;
import util.ParamCheckException;

/**
 * タイムラインを表示するアクションクラス
 *
 * @author shoma
 *
 */
public class TimeLineAction extends PerformanceAction {

    private final PerformanceService Perservice = new PerformanceService();

    @Override
    protected String processPerformanceManagement(HttpServletRequest request)
            throws ParamCheckException, DBAccessException, DataInconsistencyException {

        //セッション継続
        request.getSession(false);

        //タイムライン情報を取得
        ArrayList<MessageEntity> messageEntityList = Perservice.selectAllMessageInfo();

        //リクエストにメッセージオブジェクトリストをセット
        request.setAttribute("messageEntityList", messageEntityList);

        return "/jsp/timeLine.jsp";
    }

}
