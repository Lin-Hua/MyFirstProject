package com.bookshop2.demo.dao;


import com.bookshop2.demo.entity.Books;
import com.bookshop2.demo.entity.SalesPerson;
import org.junit.Ignore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void queryBooks() {
        List<Books> booksList=bookDao.queryBooks();
        assertEquals(3,booksList.size());
    }

    @Test
    public void queryById() {
        Books books=bookDao.queryById(1);
        assertEquals("原神",books.getBname());

    }

    @Test
    public void insertBooks() {
        Books books=new Books();
        books.setBname("斗罗大陆");
        books.setType("小说");
        books.setBuyPrice(60);
        books.setSellprice(70);
        int effectnum= bookDao.insertBooks(books);
        assertEquals(1,effectnum);
    }

    @Test
    public void updateBooksById() {
        Books books=new Books();
        books.setBno(3);
        books.setBname("斗罗大陆");
        books.setType("小说");
        books.setBuyPrice(60);
        books.setSellprice(90);
        int effectnum= bookDao.updateBooksById(books);
        assertEquals(1,effectnum);

    }

    @Test
    @Ignore
    public void deleteBooksById() {
        int effectnum =bookDao.deleteBooksById(3);
        assertEquals(1,effectnum);
    }
}