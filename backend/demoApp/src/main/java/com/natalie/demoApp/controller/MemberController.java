package com.natalie.demoApp.controller;

import com.natalie.demoApp.entity.Event;
import com.natalie.demoApp.entity.Member;
import com.natalie.demoApp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/memberDetails")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/saveMember")
    public ResponseEntity<String> saveMember(@RequestBody Member member){
        //in postman when we are entering the member details
        //and we try to save the member details into the database
        //we are entering the data in postman as json object
        //requestbody will deserialize the json to java object
        //and save member details in database

        Long id = memberService.saveMember(member);
        return new ResponseEntity<String>("Member with id '"+id+"' has been saved.", HttpStatus.OK);
    }

    @PutMapping("/memberList/{mbrNo}/events/{evtNo}")
    public ResponseEntity<Object> joinEvent(@PathVariable("mbrNo") Long mbrNo, @PathVariable("evtNo") Long evtNo){
        Member member = memberService.joinEvent(mbrNo, evtNo);
        if (member != null){
            return new ResponseEntity<>("Joined successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to join event.", HttpStatus.NOT_FOUND);
    }


    @GetMapping("/memberList")
    public ResponseEntity<List<Member>> getAllMemberDetails(){
        List<Member> list = memberService.getAllMembers();
        return new ResponseEntity<List<Member>>(list,HttpStatus.OK);
    }

    @GetMapping("/getMemberById/{mbrNo}")
    public ResponseEntity<Member> getMemberById(@PathVariable("mbrNo") Long mbrNo){
        //PathVariable to bind the url with the memberno
        Member mbr = memberService.getMemberById(mbrNo);
        return new ResponseEntity<Member>(mbr,HttpStatus.OK);
    }

    @GetMapping("/getMemberById/{mbrNo}/events")
    public ResponseEntity<Object> getMemberEvents(@PathVariable Long mbrNo){
        Set<Event> events = memberService.getMemberEvents(mbrNo);
        if (events != null){
            return new ResponseEntity<>(events, HttpStatus.OK);
        }
        return new ResponseEntity<>("No events found for this member.",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateMember/{mbrNo}")
    public ResponseEntity<String> updateMember(@PathVariable("mbrNo") Long mbrNo, @RequestBody Member member){
        Member memberById = memberService.getMemberById(mbrNo);
        memberById.setMbrName(member.getMbrName());
        memberById.setMbrSex(member.getMbrSex());
        memberById.setMbrTier(member.getMbrTier());
        Long id = memberService.saveMember(memberById);
        return new ResponseEntity<String>("Member with '"+id+"' has been updated", HttpStatus.OK);
    }

    @DeleteMapping("/deleteMember/{mbrNo}")
    public ResponseEntity<String> deleteMember(@PathVariable("mbrNo") Long mbrNo){
        memberService.deleteMember(mbrNo);
        return new ResponseEntity<>("Member with '"+mbrNo+"' has been deleted.", HttpStatus.OK);
    }
}
