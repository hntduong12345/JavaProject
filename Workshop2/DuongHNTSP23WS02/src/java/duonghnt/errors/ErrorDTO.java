package duonghnt.errors;

public class ErrorDTO {

    private String accountExistedErr;
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String confirmErr;
    private String fullnameLengthErr;

    public ErrorDTO() {
    }

    public ErrorDTO(String accountExistedErr, String usernameLengthErr, String passwordLengthErr,
            String confirmErr, String fullnameLengthErr) {
        this.accountExistedErr = accountExistedErr;
        this.usernameLengthErr = usernameLengthErr;
        this.passwordLengthErr = passwordLengthErr;
        this.confirmErr = confirmErr;
        this.fullnameLengthErr = fullnameLengthErr;
    }

    public String getAccountExistedErr() {
        return accountExistedErr;
    }

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public String getConfirmErr() {
        return confirmErr;
    }

    public String getFullnameLengthErr() {
        return fullnameLengthErr;
    }

    public void setAccountExistedErr(String accountExistedErr) {
        this.accountExistedErr = accountExistedErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public void setConfirmErr(String confirmErr) {
        this.confirmErr = confirmErr;
    }

    public void setFullnameLengthErr(String fullnameLengthErr) {
        this.fullnameLengthErr = fullnameLengthErr;
    }

}
