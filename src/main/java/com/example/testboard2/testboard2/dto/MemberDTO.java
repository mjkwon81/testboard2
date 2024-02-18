package com.example.testboard2.testboard2.dto;

public class MemberDTO {

    @Override
    public String toString() {
        return "MemberDTO [num=" + num + ", name=" + name + ", id=" + id + ", phone=" + phone + "]";
    }
    public MemberDTO() {
    }
    // name
    private int num;
    private String name;
    public void setNum(int num) {
        this.num = num;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    private String id;
    public int getNum() {
        return num;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getPhone() {
        return phone;
    }
    private String phone;

}
