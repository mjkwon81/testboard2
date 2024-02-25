package com.example.testboard2.testboard2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testboard2.testboard2.dto.MemberDTO;

@Service
public interface MemberService {
    
    public void insertMember( MemberDTO m1 );
    public MemberDTO getMemberOne( int num );
    public void updateMember( MemberDTO m1 );
    public List<MemberDTO> getMemberList();
}
