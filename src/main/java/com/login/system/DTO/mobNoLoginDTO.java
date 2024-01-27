package com.login.system.DTO;

public class mobNoLoginDTO {
    private String mobNo;

    private String pwd;

    public mobNoLoginDTO() {
    }

    public mobNoLoginDTO(String mobNo, String pwd) {
        this.mobNo = mobNo;
        this.pwd = pwd;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "mobNoLoginDTO{" +
                "mobNo='" + mobNo + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
