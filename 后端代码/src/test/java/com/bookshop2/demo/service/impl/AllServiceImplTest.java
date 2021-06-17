package com.bookshop2.demo.service.impl;

import com.bookshop2.demo.dao.BookDao;
import com.bookshop2.demo.dao.SaleDao;
import com.bookshop2.demo.entity.Books;
import com.bookshop2.demo.entity.RecordAnalysisi;
import com.bookshop2.demo.entity.Sale;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class AllServiceImplTest {

    @Autowired
    private AllServiceImpl allService=new AllServiceImpl();
    @Autowired
    SaleDao saleDao;
    @Autowired
    BookDao bookDao;
    @Test
    void addBooks() {
        Books books=new Books();
        books.setBname("斗罗大陆");
        books.setType("小说");
        books.setBuyPrice(60);
        books.setSellprice(70);
        assertEquals(true,allService.addBooks(books));
    }
    @Test
    void recordAnalysis() {
        RecordAnalysisi r1 =new RecordAnalysisi();
        r1.name="文史";
        RecordAnalysisi r2 =new RecordAnalysisi();
        r2.name="小说";
        RecordAnalysisi r3 =new RecordAnalysisi();
        r3.name="科技";
        RecordAnalysisi r4 =new RecordAnalysisi();
        r4.name="艺术";
        RecordAnalysisi r5 =new RecordAnalysisi();
        r5.name="经济";
        List<Sale> listsale = saleDao.querySale();
        for (int i = 0; i < listsale.size(); i++) {
            String type =allService.getBooksById(listsale.get(i).getBno()).getType();
            switch (type){
                case "文史":
                    r1.value++;break;
                case "小说":
                    r2.value++;break;
                case "科技":
                    r3.value++;break;
                case "艺术":
                    r4.value++;break;
                case "经济":
                    r5.value++;break;

            }
        }
        List<RecordAnalysisi> ra =new ArrayList<>();
        ra.add(r1);
        ra.add(r2);
        ra.add(r3);
        ra.add(r4);
        ra.add(r5);
        for (int i = 0; i < ra.size(); i++) {
        System.out.println(ra.get(i).value);
        }
        assertEquals(5,ra.size());
    }
}