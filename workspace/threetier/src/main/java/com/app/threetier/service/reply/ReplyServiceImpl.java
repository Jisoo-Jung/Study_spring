package com.app.threetier.service.reply;

import com.app.threetier.domain.post.Pagination;
import com.app.threetier.domain.reply.ReplyDTO;
import com.app.threetier.domain.reply.ReplyVO;
import com.app.threetier.repository.reply.ReplyDAO;
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
    public List<ReplyDTO> getReplies(Pagination pagination, Long postId){
        return replyDAO.findAll(pagination, postId)
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
