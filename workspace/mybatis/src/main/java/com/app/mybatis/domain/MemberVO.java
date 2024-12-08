package com.app.mybatis.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private Long id;
    private String memberName;
    private int memberAge;
    private String memberEmail;
    private String memberPassword;
    private boolean status;
}
