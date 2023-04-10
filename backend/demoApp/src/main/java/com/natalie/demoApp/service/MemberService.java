package com.natalie.demoApp.service;

import com.natalie.demoApp.entity.Member;

import java.util.List;

public interface MemberService {
    Integer saveMember(Member member);

    List<Member> getAllMembers();

    Member getMemberById(Integer mbrNo);

    void deleteMember(Integer mbrNo);
}
