package util;

/**
 * エラーコード・エラーメッセージを保持するクラス
 *
 * @author shoma
 *
 */
public class ErrorCodeConstValue {

    /**
     * DBアクセスエラーです。
     */
    public static final String DB_ERR = "1001";

    public static final String UNEXPECTED_ERR = "想定外のエラーが発生しました。";

    public static final String ILLEGAL_TRANSITION_ERR = "不正なページ遷移が行われました。ログイン画面からやり直してください。";

    /**
     * 該当するユーザが存在しません。ログインに失敗しました。
     */
    public static final String LOGIN_ERR = "0105";

    /**
     * ユーザIDは5桁以上12桁以下で入力してください。
     */
    public static final String USER_ID_LENGTH_ERR = "0106";

    /**
     * ユーザIDは半角英数字で入力してください。
     */
    public static final String USER_ID_TYPE_ERR = "0107";

    /**
     * パスワードは8桁以上16桁以下で入力してください。
     */
    public static final String PASSWORD_LENGTH_ERR = "0103";

    /**
     * パスワードは半角英数字で入力してください。
     */
    public static final String PASSWORD_TYPE_ERR = "0104";

    /**
     * セッションが切断されました。もう一度ログインからやり直してください。
     */
    public static final String SESSION_DISCONNECT_ERR = "0601";

    /*
     * メッセージは200文字以下で入力して下さい。
     */
    public static final String MESSAGE_LENGTH_ERR = "0701";

    /*
     * メッセージが送信出来ませんでした。
     */
    public static final String SEND_MESSAGE_ERR = "0702";

    /*
     * ユーザアカウント情報を変更出来ませんでした。
     */
    public static final String UPDATE_USERACCOUNT_ERR = "0801";

}
