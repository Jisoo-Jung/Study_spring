package com.app.threetier.mapper;

import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.reply.ReplyDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    ReplyMapper replyMapper;
    @Autowired
    MemberMapper memberMapper;

    @Test
    public void testInsert(){
        ReplyDTO replyDTO = null;
        Random random = new Random();
        int randidx = 0;
        List<MemberVO> members = memberMapper.selectAll();

        for(int i = 0; i < 250; i++){
            randidx = random.nextInt(members.size());
            replyDTO = new ReplyDTO();
            replyDTO.setReplyContent("댓글 테스트" + i + 1);
            replyDTO.setMemberId(members.get(randidx).getId());
            replyDTO.setPostId(874L);
            replyMapper.insert(replyDTO.toVO());
        }
    }
}
