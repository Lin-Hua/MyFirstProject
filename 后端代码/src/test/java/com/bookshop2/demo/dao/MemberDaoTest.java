package com.bookshop2.demo.dao;

import com.bookshop2.demo.entity.Member;
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
class MemberDaoTest {

    @Autowired
    private MemberDao memberDao;
    @Test
    @Ignore
    void queryMember() {
        List<Member> membersList=memberDao.queryMember();
        assertEquals(3,membersList.size());
    }

    @Test
    @Ignore
    void queryById() {
        Member member=memberDao.queryById(1);
        assertEquals(18146,member.getContact());
    }

    @Test
    @Ignore
    void insertMember() {
        Member member=new Member();
        member.setMname("刘安");
        member.setContact(1846598);
        int effectnum=memberDao.insertMember(member);
        assertEquals(1,effectnum);
    }

    @Test
    void updateMemberById() {
        Member member=new Member();
        member.setMno(4);
        member.setMname("刘安");
        member.setContact(1123456);
        int effectnum =memberDao.updateMemberById(member);
        assertEquals(1,effectnum);

    }

    @Test
    @Ignore
    void deleteMemberById() {
    }
}