package com.app.kakao.mapper;

import com.app.kakao.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
//    회원가입
    public void insert(MemberVO memberVO);

//    카카오 회원 정보 조회
    public Optional<MemberVO> selectByMemberKakaoEmail(String memberKakaoEmail);
}
