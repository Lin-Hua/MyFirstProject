package com.bookshop2.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "member")
public class Member {
    @Id
    private int mno;
    private String mname;
    private int contact;

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}
