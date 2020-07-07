package entity;

import java.sql.Timestamp;

public class MessageEntity {

    private String msgNo;
    private String userNo;
    private String chatName;
    private String message;
    private boolean delFlag;
    private Timestamp createDT;
    private Timestamp updateDT;
    /**
     * @return msgNo
     */
    public String getMsgNo() {
        return msgNo;
    }
    /**
     * @param msgNo セットする msgNo
     */
    public void setMsgNo(String msgNo) {
        this.msgNo = msgNo;
    }
    /**
     * @return userNo
     */
    public String getUserNo() {
        return userNo;
    }
    /**
     * @param userNo セットする userNo
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    /**
     * @return chatName
     */
    public String getChatName() {
        return chatName;
    }
    /**
     * @param chatName セットする chatName
     */
    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
    /**
     * @return message
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message セットする message
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * @return delFlag
     */
    public boolean isDelFlag() {
        return delFlag;
    }
    /**
     * @param delFlag セットする delFlag
     */
    public void setDelFlag(boolean delFlag) {
        this.delFlag = delFlag;
    }
    /**
     * @return createDT
     */
    public Timestamp getCreateDT() {
        return createDT;
    }
    /**
     * @param createDT セットする createDT
     */
    public void setCreateDT(Timestamp createDT) {
        this.createDT = createDT;
    }
    /**
     * @return updateDT
     */
    public Timestamp getUpdateDT() {
        return updateDT;
    }
    /**
     * @param updateDT セットする updateDT
     */
    public void setUpdateDT(Timestamp updateDT) {
        this.updateDT = updateDT;
    }



}
