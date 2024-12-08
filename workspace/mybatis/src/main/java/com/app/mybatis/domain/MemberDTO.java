package com.app.mybatis.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
public class MemberDTO {
    private Long id;
    private String memberName;
    private int memberAge;
    private String memberEmail;
    private String memberPassword;
    private boolean status;

    public MemberVO toVO(){
        return new MemberVO(id, memberName, memberAge, memberEmail, memberPassword, status);
    }
}
