package com.login.system.DTO;

public class EntityDTO {

    private long id;

    private String name;

    private String email;

    private String mobNo;

    private String pwd;

    public EntityDTO(long id, String name, String email, String mobNo, String pwd) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobNo = mobNo;
        this.pwd = pwd;
    }

    public EntityDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "EntityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobNo='" + mobNo + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
