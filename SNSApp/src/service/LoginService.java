package service;

import dao.UserMasterDAO;
import entity.UserEntity;
import util.DBAccessException;
import util.LoginValidator;
import util.ParamCheckException;

/**
 * ログイン処理のビジネスロジッククラス
 *
 * @author shoma
 *
 */
public class LoginService {


    private final UserMasterDAO userDao = new UserMasterDAO();

    public UserEntity login(String userId, String password) throws DBAccessException, ParamCheckException{

        //入力されたユーザIDとパスワードをチェック
        LoginValidator.checkUserId(userId);
        LoginValidator.checkPassword(password);

        return userDao.findByCredential(userId, password);
    }
}
