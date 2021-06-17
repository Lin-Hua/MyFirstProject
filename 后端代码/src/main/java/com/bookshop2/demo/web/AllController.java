package com.bookshop2.demo.web;

import com.bookshop2.demo.entity.*;
import com.bookshop2.demo.service.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping("superadmin")
public class AllController {
    @Autowired
    private AllService allService;
//    @RequestMapping(value = "/listbooks",method = RequestMethod.GET)
//    private Map<String,Object> listBooks(){
//        Map<String,Object> modelMap=new HashMap<String,Object>();
//        List<Books> listbooks=allService.getBooksList();
//        modelMap.put("booksList",listbooks);
//        return modelMap;
//    }
    @GetMapping("/findAll")
    public List<Books> findAll(){
        return allService.getBooksList();
    }

//    @RequestMapping(value = "/getbooksbyid",method = RequestMethod.GET)
//    private Map<String,Object>  getBooksById(int id) {
//        Map<String,Object> modelMap=new HashMap<String,Object>();
//        Books books=allService.getBooksById(id);
//        modelMap.put("books",books);
//        return modelMap;
//    }

    @GetMapping("/getBookById/{id}")
    public Books getBookById(@PathVariable("id") int id){
        return allService.getBooksById(id);
    }
    @RequestMapping(value ="/addbooks",method = RequestMethod.POST)
    private Map<String,Object> addBooks(@RequestBody Books books){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",allService.addBooks(books));
        return modelMap;
    }
    @RequestMapping(value ="/modifybooks",method = RequestMethod.POST)
    private Map<String,Object> modifyBooks(@RequestBody Books books){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",allService.modifyBooks(books));
        return modelMap;

    }
    @RequestMapping(value ="/deletebook",method = RequestMethod.GET)
    private Map<String,Object> deleteBooks( int id){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",allService.deleteBooks(id));
        return modelMap;

    }

//    @RequestMapping(value = "/listsale",method = RequestMethod.GET)
//    private Map<String,Object> listSale(){
//        Map<String,Object> modelMap=new HashMap<String,Object>();
//        List<Sale> listsale=allService.getSaleList();
//        modelMap.put("saleList",listsale);
//        return modelMap;
//    }
    @GetMapping("/listsale")
    public List<Sale> listsale(){
          return allService.getSaleList();
      }

//    @RequestMapping(value = "/getsalebyid",method = RequestMethod.GET)
//    private Map<String,Object>  getSaleById(int id) {
//        Map<String,Object> modelMap=new HashMap<String,Object>();
//        Sale sale=allService.getSaleById(id);
//        modelMap.put("sale",sale);
//        return modelMap;
//    }
    @GetMapping("/getRecordAnalysis")
    public List<RecordAnalysisi> analysisis(){
        return allService.recordAnalysis();
    }

    @GetMapping("/getSaleById/{id}")
    public Sale getSaleById(@PathVariable("id") int id){
        return allService.getSaleById(id);
    }
    @RequestMapping(value ="/addsale",method = RequestMethod.POST)
    private Map<String,Object> addSale(@RequestBody Sale sale){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",allService.addSale(sale));
        return modelMap;
    }
    @RequestMapping(value ="/modifysale",method = RequestMethod.POST)
    private Map<String,Object> modifySale(@RequestBody Sale sale){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",allService.modifySale(sale));
        return modelMap;

    }
    @RequestMapping(value ="/deletesale",method = RequestMethod.GET)
    private Map<String,Object> deleteSale(int id){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",allService.deleteSale(id));
        return modelMap;

    }

//    @RequestMapping(value = "/listsalesperson",method = RequestMethod.GET)
//    private Map<String,Object> listSalesPerson(){
//        Map<String,Object> modelMap=new HashMap<String,Object>();
//        List<SalesPerson> listsalesperson=allService.getSalesPersonList();
//        modelMap.put("salesPersonList",listsalesperson);
//        return modelMap;
//    }
     @GetMapping("/listsalesperson")
        public List<SalesPerson> listsalesperson(){
        return allService.getSalesPersonList();
     }


//    @RequestMapping(value = "/getsalespersonbyid",method = RequestMethod.GET)
//    private Map<String,Object>  getSalesPersonById(int id) {
//        Map<String,Object> modelMap=new HashMap<String,Object>();
//        SalesPerson salesPerson=allService.getSalesPersonById(id);
//        modelMap.put("salesPerson",salesPerson);
//        return modelMap;
//    }

    @GetMapping("/getSalePersonById/{id}")
    public SalesPerson getSalePersonById(@PathVariable("id") int id){
        return allService.getSalesPersonById(id);
    }
    @RequestMapping(value ="/addsalesperson",method = RequestMethod.POST)
    private Map<String,Object> addSalesperson(@RequestBody SalesPerson salesPerson){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",allService.addSalesPerson(salesPerson));
        return modelMap;
    }
    @RequestMapping(value ="/modifysalesperson",method = RequestMethod.POST)
    private Map<String,Object> modifySalesPerson(@RequestBody SalesPerson salesPerson){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",allService.modifySalesPerson(salesPerson));
        return modelMap;

    }
    @RequestMapping(value ="/deletesalesperson",method = RequestMethod.GET)
    private Map<String,Object> deleteSalesPerson(int id){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",allService.deleteSalePerson(id));
        return modelMap;

    }

//    @RequestMapping(value = "/listmember",method = RequestMethod.GET)
//    private Map<String,Object> listMember(){
//        Map<String,Object> modelMap=new HashMap<String,Object>();
//        List<Member> listmember=allService.getMemberList();
//        modelMap.put("memberList",listmember);
//        return modelMap;
//    }
    @GetMapping("/listmember")
    public List<Member> listmember(){
       return allService.getMemberList();
     }
//    @RequestMapping(value = "/getmemberbyid",method = RequestMethod.GET)
//    private Map<String,Object>  getMemberById(int id) {
//        Map<String,Object> modelMap=new HashMap<String,Object>();
//        Member member=allService.getMemberById(id);
//        modelMap.put("member",member);
//        return modelMap;
//    }
     @GetMapping("/getMemberById/{id}")
     public Member getMemberById(@PathVariable("id") int id){
        return allService.getMemberById(id);
     }
    @RequestMapping(value ="/addmember",method = RequestMethod.POST)
    private Map<String,Object> addMember(@RequestBody Member member){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",allService.addMember(member));
        return modelMap;
    }
    @RequestMapping(value ="/modifymember",method = RequestMethod.POST)
    private Map<String,Object> modifyMember(@RequestBody Member member){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",allService.modifyMember(member));
        return modelMap;

    }
    @RequestMapping(value ="deletemember/",method = RequestMethod.GET)
    private Map<String,Object> deleteMember(int id){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",allService.deleteMember(id));
        return modelMap;

    }


}
