package com.bookshop2.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "sale")
public class Sale {
    @Id
    private int orderno;
    private int bno;
    private int sno;
    private int mno;
    private Date saletime;

    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }

    public int getBno() {
        return bno;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public Date getSaletime() {
        return saletime;
    }

    public void setSaletime(Date saletime) {
        this.saletime = saletime;
    }
}
