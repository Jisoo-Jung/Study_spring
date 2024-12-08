package com.app.kakao.service;

import com.app.kakao.domain.MemberVO;

import java.util.Optional;

public interface MemberService {
//    회원가입
    public void join(MemberVO memberVO);
//    회원 조회
    public Optional<MemberVO> getKakaoMember(String memberKakaoEmail);
}
