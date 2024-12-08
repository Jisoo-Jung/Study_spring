package com.app.threetier.domain.reply;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
public class ReplyDTO {
    private Long id;
    private String replyContent;
    private Long memberId;
    private Long postId;
    private String createdDate;
    private String updatedDate;

    public ReplyVO toVO(){
        return new ReplyVO(id, replyContent, memberId, postId, createdDate, updatedDate);
    }
}
