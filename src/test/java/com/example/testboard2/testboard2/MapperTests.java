package com.example.testboard2.testboard2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testboard2.testboard2.dto.MemberDTO;
import com.example.testboard2.testboard2.mapper.MemberMapper;

@SpringBootTest
public class MapperTests {
    
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testInsert(){
        
        MemberDTO m1 = new MemberDTO();
        m1.setId("mr.bal");
        m1.setName("장발순");
        m1.setPhone("00011117777");

        System.out.println(m1);

        memberMapper.insertMember(m1);

        System.out.println("--------------------------------------------------");
        System.out.println("레코드가 추가되었습니다.");
        System.out.println("--------------------------------------------------");
    }
}
