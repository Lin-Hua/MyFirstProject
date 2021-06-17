package com.bookshop2.demo.dao;

import com.bookshop2.demo.entity.Sale;

import java.util.List;

public interface SaleDao {
    List<Sale> querySale();
    Sale queryById(int id);
    int insertSale(Sale sale);
    int updateSaleById(Sale sale);
    int deleteSaleById(int id);
}
