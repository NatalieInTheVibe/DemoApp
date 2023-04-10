package com.natalie.demoApp.controller;

import com.natalie.demoApp.entity.Member;
import com.natalie.demoApp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/memberDetails")
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/memberList")
    public ResponseEntity<List<Member>> getAllMemberDetails(){
        List<Member> list = service.getAllMembers();
        return new ResponseEntity<List<Member>>(list,HttpStatus.OK);
    }

    @PostMapping("/saveMember")
    public ResponseEntity<String> saveMember(@RequestBody Member member){
        //in postman when we are entering the member details
        //and we try to save the student details into the database
        //we are entering the data in postman as json object
        //requestbody will deserialize the json to java object
        //and save member details in database

        Integer id = service.saveMember(member);
        return new ResponseEntity<String>("Member with id '"+id+"' has been saved.", HttpStatus.OK);
    }

    @GetMapping("/getMemberById/{mbrNo}")
    public ResponseEntity<Member> getMemberById(@PathVariable("mbrNo") Integer mbrNo){
        //PathVariable to bind the url with the memberno
        Member mbr = service.getMemberById(mbrNo);
        return new ResponseEntity<Member>(mbr,HttpStatus.OK);
    }

    @PutMapping("/updateMember/{mbrNo}")
    public ResponseEntity<String> updateMember(@PathVariable("mbrNo") Integer mbrNo, @RequestBody Member member){
        Member memberById = service.getMemberById(mbrNo);
        memberById.setMbrName(member.getMbrName());
        memberById.setMbrSex(member.getMbrSex());
        memberById.setMbrTier(member.getMbrTier());
        Integer id = service.saveMember(memberById);
        return new ResponseEntity<String>("Student with '"+id+"' has been updated", HttpStatus.OK);
    }

    @DeleteMapping("/deleteMember/{mbrNo}")
    public ResponseEntity<String> deleteMember(@PathVariable("mbrNo") Integer mbrNo){
        service.deleteMember(mbrNo);
        return new ResponseEntity<>("Student with '"+mbrNo+"' has been deleted.", HttpStatus.OK);
    }
}
