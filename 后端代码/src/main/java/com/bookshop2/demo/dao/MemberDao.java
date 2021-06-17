package com.bookshop2.demo.dao;

import com.bookshop2.demo.entity.Member;

import java.util.List;

public interface MemberDao {
    List<Member> queryMember();
    Member queryById(int id);
    int insertMember(Member member);
    int updateMemberById(Member member);
    int deleteMemberById(int id);
}
