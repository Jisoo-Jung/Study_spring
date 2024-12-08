package com.app.mybatis.mapper;

import com.app.mybatis.domain.ReplyDTO;
import com.app.mybatis.domain.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    private ReplyMapper replyMapper;

    @Test
    public void testInsert(){
//        ReplyDTO replyDTO = new ReplyDTO();
//        replyDTO.setReplyContent("댓글 테스트2");
//        replyDTO.setMemberId(3L);
//        replyDTO.setPostId(1L);

        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setReplyContent("대댓글 테스트1");
        replyDTO.setReplyGroupId(5L);
        replyDTO.setMemberId(3L);
        replyDTO.setPostId(1L);

        replyMapper.insert(replyDTO.toVO());
    }

    @Test
    public void testSelectAll(){
//        replyMapper.selectAll().stream().map(ReplyDTO::toString).forEach(log::info);
        List<ReplyDTO> replies = replyMapper.selectAll();
//        replies.stream().filter((reply) -> reply.getReplyOrder() == 0).map(ReplyDTO::toString).forEach(log::info);
        Long replyGroupId = 5L;

        for (ReplyDTO replyDTO : replies) {
            if(replyDTO.getReplyOrder() != 0){
                if(replyDTO.getReplyGroupId() == replyGroupId) {
                    log.info("{}", replyDTO);
                }
            }
        }
    }

    @Test
    public void testUpdate(){
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setId(3L);
        replyDTO.setReplyContent("수정된 대댓글");
        replyMapper.update(replyDTO.toVO());
    }

    @Test
    public void testDelete(){
        replyMapper.delete(1L, 0);
    }
}













