package com.bookshop2.demo.service.impl;

import com.bookshop2.demo.dao.BookDao;
import com.bookshop2.demo.dao.MemberDao;
import com.bookshop2.demo.dao.SaleDao;
import com.bookshop2.demo.dao.SalesPersonDao;
import com.bookshop2.demo.entity.*;
import com.bookshop2.demo.service.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class AllServiceImpl implements AllService {
    @Autowired
    private BookDao bookDao ;
    @Autowired
    private SaleDao saleDao;
    @Autowired
    private SalesPersonDao salesPersonDao;
    @Autowired
    private MemberDao memberDao;
    @Override
    public List<Books> getBooksList() {
        return bookDao.queryBooks();
    }

    @Override
    public List<Sale> getSaleList() {
        return saleDao.querySale();
    }

    @Override
    public List<SalesPerson> getSalesPersonList() {
        return salesPersonDao.querySalesPerson();
    }

    @Override
    public List<Member> getMemberList() {
        return memberDao.queryMember();
    }

    @Override
    public Books getBooksById(int id) {
        return bookDao.queryById(id);
    }

    @Override
    public Sale getSaleById(int id) {
        return saleDao.queryById(id);
    }

    @Override
    public SalesPerson getSalesPersonById(int id) {
        return salesPersonDao.queryById(id);
    }

    @Override
    public Member getMemberById(int id) {
        return memberDao.queryById(id);
    }
    @Transactional
    @Override
    public boolean addBooks(Books books) {

        if(books.getBname()!=null && !"".equals(books.getBname())){
            try {
                int effectnum = bookDao.insertBooks(books);
                if (effectnum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("信息不为空！");
        }
    }

    @Override
    public boolean addSale(Sale sale) {
        if(sale.getBno()!=0 && sale.getMno()!=0 && sale.getSno()!=0 ){
            try {
                int effectnum = saleDao.insertSale(sale);
                if (effectnum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("会员号、书号、销售员号信息不为0！");
        }
    }

    @Override
    public boolean addSalesPerson(SalesPerson salesPerson) {
        if(salesPerson.getSname()!=null && !"".equals(salesPerson.getSname())){
            try {
                int effectnum = salesPersonDao.insertSalesPerson(salesPerson);
                if (effectnum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("销售人员姓名不为空！");
        }
    }

    @Override
    public boolean addMember(Member member) {
        if(member.getMname()!=null && !"".equals(member.getMname())){
            try {
                int effectnum = memberDao.insertMember(member);
                if (effectnum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("会员姓名不为空！");
        }
    }

    @Override
    public boolean modifyBooks(Books books) {
        if( books.getBno()>0){
            try {
                int effectnum = bookDao.updateBooksById(books);
                if (effectnum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("修改信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("书号不为0！");
        }
    }

    @Override
    public boolean modifySale(Sale sale) {
        if( sale.getOrderno()>0){
            try {
                int effectnum = saleDao.updateSaleById(sale);
                if (effectnum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("修改信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("订单号不为0！");
        }
    }

    @Override
    public boolean modifySalesPerson(SalesPerson salesPerson) {
        if( salesPerson.getSno()>0){
            try {
                int effectnum = salesPersonDao.updateSalesPersonById(salesPerson);
                if (effectnum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("销售员编号不为0！");
        }
    }

    @Override
    public boolean modifyMember(Member member) {
        if( member.getMno()>0){
            try {
                int effectnum = memberDao.updateMemberById(member);
                if (effectnum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("修改信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("会员编号不为0！");
        }
    }

    @Override
    public boolean deleteBooks(int id) {
        if( id >0){
            try {
                int effectnum = bookDao.deleteBooksById(id);
                if (effectnum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("书号不为0！");
        }
    }

    @Override
    public boolean deleteSale(int id) {
        if( id >0){
            try {
                int effectnum = saleDao.deleteSaleById(id);
                if (effectnum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("订单号不为0！");
        }
    }

    @Override
    public boolean deleteSalePerson(int id) {
        if( id >0){
            try {
                int effectnum = salesPersonDao.deleteSalesPersonById(id);
                if (effectnum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("订单号不为0！");
        }
    }

    @Override
    public boolean deleteMember(int id) {
        if( id >0){
            try {
                int effectnum = memberDao.deleteMemberById(id);
                if (effectnum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("会员号不为0！");
        }
    }

    @Override
    public List<RecordAnalysisi> recordAnalysis() {
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
            String type =bookDao.queryById(listsale.get(i).getBno()).getType();
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
        return ra;
    }
}
