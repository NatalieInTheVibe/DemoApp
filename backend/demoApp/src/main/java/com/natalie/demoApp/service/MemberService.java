package com.natalie.demoApp.service;

import com.natalie.demoApp.entity.Event;
import com.natalie.demoApp.entity.Member;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MemberService {
    Long saveMember(Member member);

    List<Member> getAllMembers();

    Member getMemberById(Long mbrNo);

    void deleteMember(Long mbrNo);

    Member joinEvent(Long mbrNo, Long evtNo);

    Set<Event> getMemberEvents(Long mbrNo);
}
