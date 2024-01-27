package com.login.system.DTO;

public class mobNoAndEmailDTO {

    private String mobNo;

    private String email;

    private String pwd;

    public mobNoAndEmailDTO() {
    }

    public mobNoAndEmailDTO(String mobNo, String email, String pwd) {
        this.mobNo = mobNo;
        this.email = email;
        this.pwd = pwd;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
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
