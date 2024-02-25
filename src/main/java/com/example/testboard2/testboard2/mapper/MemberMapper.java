package com.example.testboard2.testboard2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.testboard2.testboard2.dto.MemberDTO;

@Mapper
public interface MemberMapper {
    
    public void insertMember(MemberDTO memberDTO);
    public MemberDTO selectMemberOne( int num);
    public void updateMember(MemberDTO memberDTO);
    public List<MemberDTO> selectMemberAll();
}
