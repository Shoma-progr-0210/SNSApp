package util;

public class SNSAppException extends Exception {

    private String errCD = null;

    public SNSAppException(String errCD) {
        setErrCD(errCD);
    }

    /**
     * @return errCD
     */
    public String getErrCD() {
        return errCD;
    }

    /**
     * @param errCD セットする errCD
     */
    public void setErrCD(String errCD) {
        this.errCD = errCD;
    }
}
