package com.bookshop2.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "books")
public class Books {
    @Id
    private int  bno;
    private String bname;
    private String types;
    private float buyprice;
    private float sellprice;

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getType() {
        return types;
    }

    public void setType(String type) {
        this.types = type;
    }

    public float getBuyPrice() {
        return buyprice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyprice = buyPrice;
    }

    public float getSellprice() {
        return sellprice;
    }

    public void setSellprice(float sellprice) {
        this.sellprice = sellprice;
    }
}

