package com.natalie.demoApp.service;

import com.natalie.demoApp.repos.MemberRepository;
import com.natalie.demoApp.entity.Member;
import com.natalie.demoApp.exception.MemberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.natalie.demoApp.service.MemberService;

import java.util.List;

@Service
public class MemberServiceImplements implements MemberService{

    @Autowired
    private MemberRepository repository;

    @Override
    public List<Member> getAllMembers(){
        return (List<Member>) repository.findAll();
    }

    @Override
    public Member getMemberById(Integer mbrNo){
        return repository.findById(mbrNo)
                .orElseThrow(()-> new MemberNotFoundException(mbrNo));//what if it is not present?
    }
    @Override
    public Integer saveMember(Member member){
        return repository.save(member).getMbrNo();
    }

    @Override
    public void deleteMember(Integer mbrNo) {
        repository.deleteById(mbrNo);
    }
}
