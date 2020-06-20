package util;

/**
 * 入力チェックを管理するクラス
 *
 * @author shoma
 *
 */
public class Validator {

    public static void  checkUserId(String userId) throws ParamCheckException {

        //ユーザIDが5桁以上12桁以下でないときにエラースロー
        if (userId.length() < 5 || userId.length() > 12 ) {
            throw new ParamCheckException(ErrorCodeConstValue.USER_ID_LENGTH_ERR);
        }

        //ユーザIDが半角英数字でないときにエラースロー
        if (!userId.matches("^[0-9a-z]+$")) {
            throw new ParamCheckException(ErrorCodeConstValue.USER_ID_TYPE_ERR);
        }
    }
}
