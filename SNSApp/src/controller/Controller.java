package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionFactory;
import util.ErrorCodeConstValue;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/control")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //文字コードを設定
        request.setCharacterEncoding("UTF-8");

        //遷移のためのリクエストディスパッチャー
        RequestDispatcher rd = null;

        try {
            //遷移先で指定されたアクションを取得
            String strActionName = request.getParameter("action_name");
            Action action = ActionFactory.getInstance(strActionName);

            if (action == null) {
                //アクションが取得出来なかった場合、セッションを破棄してログアウトページに遷移
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.invalidate();
                }

                //ログアウトでない場合、エラーメッセージを表示
                if (!"logout".equals(strActionName)) {
                    request.setAttribute("errorMsg", ErrorCodeConstValue.ILLEGAL_TRANSITION_ERR);
                    //エラーページへの遷移決定
                    rd = request.getRequestDispatcher("/jsp/loginError.jsp");

                } else {

                    //ログアウトページへの遷移決定
                    rd = request.getRequestDispatcher("/jsp/logout.jsp");
                }
            } else {
                //アクションが取得出来た場合、処理を実行して遷移先ページを取得
                String forwardPath = action.execute(request);
                rd = request.getRequestDispatcher(forwardPath);
            }
        } catch (Exception e) {
            //例外のスタックトレースを出力
            e.printStackTrace();
            //例外が発生した場合、エラーメッセージをセットしてエラー画面に遷移
            request.setAttribute("errorMsg", ErrorCodeConstValue.UNEXPECTED_ERR);
            rd = request.getRequestDispatcher("/jsp/error.jsp");
        }
        //遷移先のページに遷移
        rd.forward(request, response);

    }


}
