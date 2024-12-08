package com.app.kakao.repository;

import com.app.kakao.domain.MemberVO;
import com.app.kakao.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

    public Optional<MemberVO> findByMemberKakaoEmail(String memberKakaoEmail){
        return memberMapper.selectByMemberKakaoEmail(memberKakaoEmail);
    }
}
