package com.example.boardtest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String mid;
    private String userid;
    private String password;

    public String getMId() {
        return mid;
    }


    public void setMId(String id) {
        this.mid = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + mid + '\'' +
                ", userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
