package com.example.testboard2.testboard2.dto;

public class MemberDTO {

    // idx
    private Long idx;
    
    // name
    private String name;
    private String id;
    private String phone;

    public MemberDTO() {
    }

    public void setIdx(Long idx) {
        this.idx = idx;
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
    
    public Long getIdx() {
        return idx;
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

    @Override
    public String toString() {
        return "MemberDTO [idx=" + idx + ", name=" + name + ", id=" + id + ", phone=" + phone + "]";
    }

    

}

