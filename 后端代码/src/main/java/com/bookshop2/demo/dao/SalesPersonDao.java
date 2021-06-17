package com.bookshop2.demo.dao;

import com.bookshop2.demo.entity.SalesPerson;

import java.util.List;

public interface SalesPersonDao {
    List<SalesPerson> querySalesPerson();
    SalesPerson queryById(int id);
    int insertSalesPerson(SalesPerson salesPerson);
    int updateSalesPersonById(SalesPerson salesPerson);
    int deleteSalesPersonById(int id);
}
