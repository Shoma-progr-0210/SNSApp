package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.UserAccountEntity;
import service.PerformanceService;
import util.DBAccessException;
import util.DataInconsistencyException;
import util.ParamCheckException;

public class SettingUserAccountAction extends PerformanceAction {

    private final PerformanceService PerService = new PerformanceService();

    @Override
    protected String processPerformanceManagement(HttpServletRequest request)
            throws ParamCheckException, DBAccessException, DataInconsistencyException{

        //セッション継続
        HttpSession session = request.getSession(false);

        //セッションからユーザのアカウント情報を取得
        UserAccountEntity oldUserAccountEntity = (UserAccountEntity) session.getAttribute("userAccountEntity");

        //ユーザアカウント情報からユーザNOを取得
        String userId = oldUserAccountEntity.getUserNo();

        //ユーザアカウント情報を取得
        UserAccountEntity userAccountEntity = PerService.userInfo(userId);

        //セッションのユーザアカウント情報を更新
        session.setAttribute("userAccountEntity", userAccountEntity);

        return "/jsp/settingUserAccount.jsp";
    }

}
