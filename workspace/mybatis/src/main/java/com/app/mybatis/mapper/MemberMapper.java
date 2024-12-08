package com.app.mybatis.mapper;

import com.app.mybatis.domain.MemberVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
//    회원가입
    public void insert(MemberVO memberVO);
    
//    로그인
    public MemberVO selectByMemberEmailAndMemberPassword(MemberVO memberVO);

//    회원탈퇴
    public void hardDelete(Long id);
    public void softDelete(MemberVO memberVO);
}
