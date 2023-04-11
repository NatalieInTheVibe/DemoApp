package com.natalie.demoApp.service;

import com.natalie.demoApp.repos.EventRepository;
import com.natalie.demoApp.repos.MemberRepository;
import com.natalie.demoApp.entity.Event;
import com.natalie.demoApp.entity.Member;
import com.natalie.demoApp.exception.RuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.natalie.demoApp.service.MemberService;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MemberServiceImplements implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Long saveMember(Member member){
        return memberRepository.save(member).getMbrNo();
    }

    @Override
    public List<Member> getAllMembers(){
        return (List<Member>) memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long mbrNo){
        return memberRepository.findById(mbrNo)
                .orElseThrow(()-> new RuntimeException(mbrNo));//what if it is not present?
    }

    @Override
    public void deleteMember(Long mbrNo) {
        if (!eventRepository.existsById(mbrNo)) {
            throw new RuntimeException(mbrNo);
        }
        memberRepository.deleteById(mbrNo);
    }

    @Override
    public Member joinEvent(Long mbrNo, Long evtNo) {
        Optional<Member> mbr = memberRepository.findById(mbrNo);
        Optional<Event> evt = eventRepository.findById(evtNo);
        if (evt.isPresent() && mbr.isPresent()) {
            Member member = mbr.get();
            Event event = evt.get();

            member.getEvents().add(event);
            event.getMembers().add(member);

            memberRepository.save(member);
            eventRepository.save(event);

            return member;//need to change?
        }
        return null;
    }

    @Override
    public Set<Event> getMemberEvents(Long mbrNo) {
        Optional<Member> memberOpt = memberRepository.findById(mbrNo);
        if (memberOpt.isPresent()) {
            Member member = memberOpt.get();
            return member.getEvents();
        }
        return null;
    }


}
