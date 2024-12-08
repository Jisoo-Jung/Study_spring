package com.app.app.domain.post;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long memberId;
    private String createdDate;
    private String updatedDate;
    private int postReadCount;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public PostVO toVO(){
        return new PostVO(id, postTitle, postContent, memberId, createdDate, updatedDate, postReadCount);
    }
}
