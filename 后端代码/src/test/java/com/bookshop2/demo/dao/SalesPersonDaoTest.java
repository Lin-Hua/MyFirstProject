package com.bookshop2.demo.dao;

import com.bookshop2.demo.entity.SalesPerson;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class SalesPersonDaoTest {

    @Autowired
    private SalesPersonDao salesPersonDao;
    @Test
    @Ignore
    void querySalesperson() {
        List<SalesPerson> Slist=salesPersonDao.querySalesPerson();
        assertEquals(2,Slist.size());
    }

    @Test
    @Ignore
    void queryById() {
    }

    @Test
    void insertSalesPerson() {
        SalesPerson salesPerson=new SalesPerson();
        salesPerson.setSname("王五");
        salesPerson.setAge(56);
        salesPerson.setSex("男");
        salesPerson.setPhone(123456);
        int effectnum =salesPersonDao.insertSalesPerson(salesPerson);
        assertEquals(1,effectnum);
    }

    @Test
    @Ignore
    void updateSalesPersonById() {
    }

    @Test
    @Ignore
    void deleteSalesPersonById() {
    }
}