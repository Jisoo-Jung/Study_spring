package com.app.threetier.service.reply;

import com.app.threetier.domain.post.Pagination;
import com.app.threetier.domain.reply.ReplyDTO;
import com.app.threetier.domain.reply.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyService {
//    댓글 추가
    public void write(ReplyVO replyVO);

//    댓글 목록
    public List<ReplyDTO> getReplies(Pagination pagination, Long postId);

//    댓글 수정
    public void setReply(ReplyVO replyVO);

//    댓글 삭제
    void delete(Long id);

//    댓글 전체 개수
    public int getTotal(Long postId);
}
