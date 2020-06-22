package entity;

import java.time.LocalDateTime;

public class MessageEntity {

    private String msgNo;
    private String userNo;
    private String message;
    private boolean delFlag;;
    private LocalDateTime createDT;
    private LocalDateTime updateDT;
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
    public LocalDateTime getCreateDT() {
        return createDT;
    }
    /**
     * @param createDT セットする createDT
     */
    public void setCreateDT(LocalDateTime createDT) {
        this.createDT = createDT;
    }
    /**
     * @return updateDT
     */
    public LocalDateTime getUpdateDT() {
        return updateDT;
    }
    /**
     * @param updateDT セットする updateDT
     */
    public void setUpdateDT(LocalDateTime updateDT) {
        this.updateDT = updateDT;
    }



}
