package com.app.mybatis.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private int postReadCount;
    private boolean status;
    private String createdDate;
    private String updatedDate;
    private Long memberId;
    private String memberName;
    private int memberAge;
    private String memberEmail;

    public PostVO toVO(){
        return new PostVO(id, postTitle, postContent, postReadCount, status, createdDate, updatedDate, memberId);
    }
}
