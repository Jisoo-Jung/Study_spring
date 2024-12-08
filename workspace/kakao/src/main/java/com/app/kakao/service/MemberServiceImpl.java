package com.app.kakao.service;

import com.app.kakao.domain.MemberDTO;
import com.app.kakao.domain.MemberVO;
import com.app.kakao.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

    @Override
    public void join(MemberVO memberVO) {
        Optional<MemberVO> foundKakaoMember
                = memberDAO.findByMemberKakaoEmail(memberVO.getMemberKakaoEmail());

        if(foundKakaoMember.isEmpty()){
            memberDAO.save(memberVO);
        }
    }

    @Override
    public Optional<MemberVO> getKakaoMember(String memberKakaoEmail){
        return memberDAO.findByMemberKakaoEmail(memberKakaoEmail);
    }
}




















