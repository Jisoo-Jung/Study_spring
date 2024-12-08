package com.app.app.service.reply;

import com.app.app.domain.post.Pagination;
import com.app.app.domain.reply.ReplyDTO;
import com.app.app.domain.reply.ReplyListDTO;
import com.app.app.domain.reply.ReplyVO;

import java.util.List;

public interface ReplyService {
//    댓글 추가
    public void write(ReplyVO replyVO);

//    댓글 목록
    public ReplyListDTO getReplies(int page, Pagination pagination, Long postId);

//    댓글 수정
    public void setReply(ReplyVO replyVO);

//    댓글 삭제
    void delete(Long id);

//    댓글 전체 개수
    public int getTotal(Long postId);
}
