package util;

public class PerformanceValidator extends Validator {


    /**
     * メッセージのチェックメソッド
     *
     * @throws ParamCheckException
     *
     * @param message
     */
    public static void checkMessage(String message) throws ParamCheckException{

        //メッセージのhtmlタグエスケープ
        message = message
                .replace("&", "&amp;")
                .replace("\"", "&quot;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("'", "&#39;");

        //メッセージの文字数チェック
        if (message.length() > 200) {
            throw new ParamCheckException(ErrorCodeConstValue.MESSAGE_LENGTH_ERR);
        }
    }

}
