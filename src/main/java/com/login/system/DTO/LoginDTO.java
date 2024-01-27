package com.login.system.DTO;

public class LoginDTO {
    private String email;
    private String pwd;


    public LoginDTO() {
        super();
    }

    public LoginDTO(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
