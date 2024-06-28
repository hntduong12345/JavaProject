/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.model;

/**
 *
 * @author ASUS
 */
public class ErrorModel {
    private String dupplicatedUsernameError;
    private String confirmError;
    private String usernameLengthError;
    private String passwordFormatError;
    private String authorizationError;
    private String fullNameLengthError;
    private String emailError;

    public ErrorModel() {
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getFullNameLengthError() {
        return fullNameLengthError;
    }

    public void setFullNameLengthError(String fullNameLengthError) {
        this.fullNameLengthError = fullNameLengthError;
    }

    public String getDupplicatedUsernameError() {
        return dupplicatedUsernameError;
    }

    public void setDupplicatedUsernameError(String dupplicatedUsernameError) {
        this.dupplicatedUsernameError = dupplicatedUsernameError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getUsernameLengthError() {
        return usernameLengthError;
    }

    public void setUsernameLengthError(String usernameLengthError) {
        this.usernameLengthError = usernameLengthError;
    }

    public String getPasswordFormatError() {
        return passwordFormatError;
    }

    public void setPasswordFormatError(String passwordFormatError) {
        this.passwordFormatError = passwordFormatError;
    }

    public String getAuthorizationError() {
        return authorizationError;
    }

    public void setAuthorizationError(String authorizationError) {
        this.authorizationError = authorizationError;
    }
    
}
