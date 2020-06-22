package entity;

import java.io.Serializable;

public class UserEntity implements Serializable{

    private String userId;
    private String password;
    /**
     * @return userName
     */
    public String getUserId() {
        return userId;
    }
    /**
     * @param userName セットする userName
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**
     * @return passWord
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password セットする password
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
