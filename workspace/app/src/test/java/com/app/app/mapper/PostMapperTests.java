package com.app.app.mapper;

import com.app.app.domain.post.Pagination;
import com.app.app.domain.post.PostDTO;
import com.app.app.domain.post.Search;
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
    public void testSelectAll(){
        Pagination pagination = new Pagination();
        pagination.setTotal(postMapper.selectTotal());
        pagination.progress();
        log.info("{}, {}", pagination.getStartRow(), pagination.getRowCount());
        postMapper.selectAll(pagination, new Search()).stream()
                .map(PostDTO::toString).forEach(log::info);
    }
}
