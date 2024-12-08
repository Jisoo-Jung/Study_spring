package com.app.app.mapper;

import com.app.app.domain.post.Pagination;
import com.app.app.domain.post.PostDTO;
import com.app.app.domain.reply.ReplyDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private ReplyMapper replyMapper;


    @Test
    public void testSelectAll(){
        PostDTO postDTO = null;
        Pagination pagination = new Pagination();
        postDTO = postMapper.selectById(1L).get();
        pagination.setTotal(replyMapper.selectCount(postDTO.getId()));
        pagination.progress();
        replyMapper.selectAll(pagination, postDTO.getId()).stream()
                .map(ReplyDTO::toString).forEach(log::info);
    }
}
