package com.login.system.PayloadResponse;

public class LoginResponse {

    String message;
    Boolean status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public LoginResponse() {
    }

    @Override
    public String toString() {
        return "LoginMassage{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
