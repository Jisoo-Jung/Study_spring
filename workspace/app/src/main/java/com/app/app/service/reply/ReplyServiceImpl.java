package com.app.app.service.reply;

import com.app.app.aspect.annotation.LogStatus;
import com.app.app.domain.post.Pagination;
import com.app.app.domain.reply.ReplyDTO;
import com.app.app.domain.reply.ReplyListDTO;
import com.app.app.domain.reply.ReplyVO;
import com.app.app.repository.reply.ReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final ReplyDAO replyDAO;
//    댓글 추가
    @Override
    public void write(ReplyVO replyVO){
        replyDAO.save(replyVO);
    }

//    댓글 목록
    @Override
    @LogStatus
    public ReplyListDTO getReplies(int page, Pagination pagination, Long postId){
        ReplyListDTO replyListDTO = new ReplyListDTO();
        pagination.setPage(page);
        pagination.setTotal(replyDAO.getTotal(postId));
        pagination.progress();
        replyListDTO.setPagination(pagination);
        replyListDTO.setReplies(replyDAO.findAll(pagination, postId));
        return replyListDTO;
    }

//    댓글 수정
    @Override
    public void setReply(ReplyVO replyVO){
        replyDAO.update(replyVO);
    }


    //    댓글 삭제
    @Override
    public void delete(Long id){
        replyDAO.delete(id);
    }

    @Override
    public int getTotal(Long postId) {
        return replyDAO.getTotal(postId);
    }
}
