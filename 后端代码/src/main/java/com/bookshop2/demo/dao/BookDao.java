package com.bookshop2.demo.dao;

import com.bookshop2.demo.entity.Books;
import java.util.List;

public interface BookDao {
    List<Books> queryBooks();
    Books queryById(int id);
    int insertBooks(Books books);
    int updateBooksById(Books books);
    int deleteBooksById(int id);
}
