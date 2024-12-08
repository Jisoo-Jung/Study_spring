package com.app.threetier.mapper;

import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.domain.post.Pagination;
import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;
import com.app.threetier.domain.post.Search;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testInsert(){
        PostDTO postDTO = null;
        Random random = new Random();
        int randidx = 0;
        List<MemberVO> members = memberMapper.selectAll();

        for(int i = 0; i < 874; i++){
            randidx = random.nextInt(members.size());
            postDTO = new PostDTO();
            postDTO.setPostTitle("테스트 제목" + i + 1);
            postDTO.setPostContent("테스트 내용" + i + 1);
            postDTO.setMemberId(members.get(randidx).getId());
//            postDTO.setMemberId(1L);
            postDTO.setPostReadCount(i * randidx);
            postMapper.insert(postDTO.toVO());
        }
    }

    @Test
    public void testSelectAll(){
        Pagination pagination = new Pagination();
        Search search = new Search();

        pagination.setPage(3);
        pagination.setTotal(postMapper.selectTotal());
        pagination.progress();

//        search.setTypes(new String[]{"post-title", "member-name"});
//        search.setKeyword("41");

        List<PostDTO> posts = postMapper.selectAll(pagination, search);
        log.info("{}", posts.size());
        posts.stream().map(PostDTO::toString).forEach(log::info);
    }
}

















