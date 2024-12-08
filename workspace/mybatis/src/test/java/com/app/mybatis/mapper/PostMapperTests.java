package com.app.mybatis.mapper;

import com.app.mybatis.domain.PostDTO;
import com.app.mybatis.domain.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void testInsert(){
        PostVO postVO =
                new PostVO(
                        null, "테스트 제목2", "테스트 내용2",
                        0, true,
                        null, null, 3L);

        postMapper.insert(postVO);
    }

    @Test
    public void testSelectAll(){

        postMapper.selectAll().stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void testSelectById(){
        Long id = 1L;
        log.info("{}", postMapper.selectById(id).toString());
        postMapper.increaseReadCount(id);
    }

    @Test
    public void testUpdate(){
        PostDTO postDTO = postMapper.selectById(1L);
        postDTO.setPostTitle("수정된 게시글 제목");
        postMapper.update(postDTO.toVO());
    }

    @Test
    public void testSoftDelete(){
        postMapper.softDelete(2L);
    }

    @Test
    public void testSelectAllOrdered(){
        postMapper.selectAllOrdered().stream().map(PostDTO::toString).forEach(log::info);
    }
}


















