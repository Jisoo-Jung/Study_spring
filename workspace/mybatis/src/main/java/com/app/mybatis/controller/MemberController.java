package com.app.mybatis.controller;

import com.app.mybatis.domain.MemberDTO;
import com.app.mybatis.mapper.MemberMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// MEMBER 테이블을 제작한다.
// ID, MEMBER_NAME, MEMBER_AGE
@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberMapper memberMapper;

    @GetMapping("join")
    public void join(MemberDTO memberDTO){
        memberMapper.insert(memberDTO.toVO());
    }

    @GetMapping("login")
    public void login(MemberDTO memberDTO){
        if(memberMapper.selectByMemberEmailAndMemberPassword(memberDTO.toVO()) == null){
            log.info("로그인 실패");
        }else{
            log.info("로그인 성공");
        }
    }

    @GetMapping("delete")
    public void delete(MemberDTO memberDTO){
//        hard delete
//        memberMapper.hardDelete(memberDTO.getId());

//        soft delete
//        memberMapper.softDelete(memberDTO.toVO());
    }
}
