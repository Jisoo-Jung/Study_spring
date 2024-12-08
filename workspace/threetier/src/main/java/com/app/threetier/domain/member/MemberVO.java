package com.app.threetier.domain.member;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
//  Serializable
//  직렬화란, 주소값을 세션에 저장할 때 안전하게 저장하기 위함이다.
//  메모리의 주소가 변경되면 기존에 저장되어있던 주소는 무의미하기 때문에
//  주소가 아닌 정보를 모두 문자열 형태로(JSON 형식) 바꿔서 저장하는 기법이다.
//  이렇게 직렬화된 정보를 사용할 때에는 역직렬화를 통해 새로운 객체가 생성되고 정보가 담긴다.
public class MemberVO implements Serializable{
    @EqualsAndHashCode.Include
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public MemberDTO toDTO(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(id);
        memberDTO.setMemberEmail(memberEmail);
        memberDTO.setMemberPassword(memberPassword);
        memberDTO.setMemberName(memberName);
        return memberDTO;
    }
}
