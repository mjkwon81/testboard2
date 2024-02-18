package com.example.testboard2.testboard2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testboard2.testboard2.dto.MemberDTO;
import com.example.testboard2.testboard2.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void insertMember(MemberDTO m1) {

        System.out.println(this.);
        memberMapper.insertMember(m1);
    }

    /*
     * Select Member One·
     */
    @Override
    public MemberDTO getMemberOne( int num) {

        return memberMapper.selectMemberOne( num );
    }

    /*
     * UPDATE
     */
    @Override
    public void updateMember(MemberDTO m1) {
        System.out.println("updateMember");
        memberMapper.updateMember(m1);
    }
    
}
