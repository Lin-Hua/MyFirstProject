package com.bookshop2.demo.service;

import com.bookshop2.demo.entity.*;

import java.util.List;

public interface AllService {
    List<Books> getBooksList();
    List<Sale> getSaleList();
    List<SalesPerson> getSalesPersonList();
    List<Member> getMemberList();
    Books getBooksById(int id);
    Sale getSaleById(int id);
    SalesPerson getSalesPersonById(int id);
    Member getMemberById(int id);
    boolean addBooks(Books books);
    boolean addSale(Sale sale);
    boolean addSalesPerson(SalesPerson salesPerson);
    boolean addMember(Member member);
    boolean modifyBooks(Books books);
    boolean modifySale(Sale sale);
    boolean modifySalesPerson(SalesPerson salesPerson);
    boolean modifyMember(Member member);
    boolean deleteBooks(int id);
    boolean deleteSale(int id);
    boolean deleteSalePerson(int id);
    boolean deleteMember(int id);
    List<RecordAnalysisi> recordAnalysis();
}
