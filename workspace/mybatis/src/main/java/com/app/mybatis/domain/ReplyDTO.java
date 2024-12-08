package com.app.mybatis.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    private Long id;
    private String replyContent;
    private Long replyGroupId;
    private int replyOrder;
    private String createdDate;
    private String updatedDate;
    private Long memberId;
    private Long postId;
    private String memberName;

    public ReplyVO toVO(){
        return new ReplyVO(id, replyContent, replyGroupId, replyOrder, createdDate, updatedDate, memberId, postId);
    }
}
