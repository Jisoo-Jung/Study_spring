package com.app.kakao.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberKakaoEmail;
    private String memberKakaoProfileUrl;
    private String memberName;
    private boolean memberStatus;
    private String memberLoginType;

    public MemberVO toVO(){
        return new MemberVO(id, memberEmail, memberPassword, memberKakaoEmail, memberKakaoProfileUrl, memberName, memberStatus, memberLoginType);
    }
}
