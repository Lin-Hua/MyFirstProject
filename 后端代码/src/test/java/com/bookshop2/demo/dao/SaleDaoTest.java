package com.bookshop2.demo.dao;

import com.bookshop2.demo.entity.Sale;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class SaleDaoTest {

    @Autowired
    private SaleDao saleDao;
    @Test
    void querySale() {
        List<Sale> salelist=saleDao.querySale();
        assertEquals(3,salelist.size());
    }

    @Test
    void queryById() {
        Sale sale=saleDao.queryById(1);
        int a=sale.getBno();
        assertEquals(1,a);
    }

    @Test
    void insertSale() {
        Date date=new Date();
        Sale sale=new Sale();
        sale.setBno(1);
        sale.setMno(2);
        sale.setSno(2);
        sale.setSaletime(date);
        int effectnum=saleDao.insertSale(sale);
        assertEquals(1,effectnum);
    }

    @Test
    void updateSaleById() {
        Date date=new Date();
        Sale sale=new Sale();
        sale.setOrderno(3);
        sale.setBno(1);
        sale.setMno(2);
        sale.setSno(2);
        sale.setSaletime(date);
        int effectnum=saleDao.updateSaleById(sale);
        assertEquals(1,effectnum);
    }

    @Test
    void deleteSaleById() {
    }
}