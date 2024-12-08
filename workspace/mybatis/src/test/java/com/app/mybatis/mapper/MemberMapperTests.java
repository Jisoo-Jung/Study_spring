package com.app.mybatis.mapper;

import com.app.mybatis.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testInsert(){
        MemberVO memberVO = new MemberVO(null, "한동석", 20, "test@gmail.com", "1234", true);
        memberMapper.insert(memberVO);
    }

    @Test
    public void testSelectByMemberEmailAndMemberPassword(){
        MemberVO memberVO = new MemberVO(null, null, 0, "test@gmail.com", "1234", true);
        MemberVO foundMember = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        log.info("{}", foundMember);
    }

    @Test
    public void testHardDelete(){
        MemberVO memberVO = new MemberVO(null, null, 0, "test@gmail.com", "1234", true);
        MemberVO foundMember = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        if(foundMember != null){
            memberMapper.hardDelete(foundMember.getId());
        }
    }

    @Test
    public void testSoftDelete(){
        MemberVO memberVO = new MemberVO(null, null, 0, "test@gmail.com", "1234", true);
        MemberVO foundMember = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        if(foundMember != null){
            memberMapper.softDelete(foundMember);
        }
    }
}
















