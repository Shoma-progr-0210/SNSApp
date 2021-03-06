package action;

public class ActionFactory {


    /**
     * 指定された文字列に該当するActionクラスのオブジェクトを取得するファクトリークラス
     *
     * @param actionName
     * @return
     */
    public static Action getInstance(String actionName) {

        //引数がnullの時、nullを返却
        if (actionName == null) {
            return null;
        }

        switch(actionName) {
        //引数が「login」の時、LoginActionオブジェクトを返却
        case "login":
            return new LoginAction();
        case "message":
            return new MessageAction();
        case "timeLine":
            return new TimeLineAction();
        case "sendMessage":
            return new SendMessageAction();
        case "setting":
            return new SettingAction();
        case "settingUserAccount":
            return new SettingUserAccountAction();
        default:
            return null;
        }

    }

}
