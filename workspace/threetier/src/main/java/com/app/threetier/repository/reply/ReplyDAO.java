package com.app.threetier.repository.reply;

import com.app.threetier.domain.post.Pagination;
import com.app.threetier.domain.reply.ReplyDTO;
import com.app.threetier.domain.reply.ReplyVO;
import com.app.threetier.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;
//    댓글 추가
    public void save(ReplyVO replyVO){
        replyMapper.insert(replyVO);
    }

//    댓글 목록
    public List<ReplyDTO> findAll( Pagination pagination, Long postId){
        return replyMapper.selectAll(pagination, postId);
    }

//    댓글 수정
    public void update(ReplyVO replyVO){
        replyMapper.update(replyVO);
    }

//    댓글 삭제
    public void delete(Long id){
        replyMapper.delete(id);
    }

//    댓글 전체 개수
    public int getTotal(Long postId){
        return replyMapper.selectCount(postId);
    }
}
















