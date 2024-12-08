package com.app.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {
    private Long id;
    private String replyContent;
    private Long replyGroupId;
    private int replyOrder;
    private String createdDate;
    private String updatedDate;
    private Long memberId;
    private Long postId;
}
