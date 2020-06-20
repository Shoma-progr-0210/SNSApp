package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.UserEntity;

public class LoginValidator extends Validator{

    /**
     * セッションオブジェクトにユーザ情報が格納されているかを確認するメソッド
     *
     * @param request
     * @return
     */
    public static boolean checkSession(HttpServletRequest request) {
        //セッションオブジェクトを取得
        HttpSession session = request.getSession(false);

        //セッションにUserEntityオブジェクトが格納されていなければfalse
        if (session == null) {
            return false;
        }else if(session.getAttribute("userEntity") == null){
            return false;
        }

        //セッションからUserEntityオブジェクトを取得
        UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");

        //UserEntityオブジェクトのユーザIDがnullならfalse
        if (userEntity.getUserId() == null) {
            return false;
        }
        return true;
    }

    public static void checkPassword(String password) throws ParamCheckException {

        //パスワードが8桁以上16桁以下でないときにエラースロー
        if (password.length() <8 || password.length() > 16) {
            throw new ParamCheckException(ErrorCodeConstValue.PASSWORD_LENGTH_ERR);
        }

        //パスワードが半角英数字でないときにエラースロー
        if (!password.matches("^[0-9a-zA-Z]+$")) {
            throw new ParamCheckException(ErrorCodeConstValue.PASSWORD_TYPE_ERR);
        }
    }
}
