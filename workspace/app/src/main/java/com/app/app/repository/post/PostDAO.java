package com.app.app.repository.post;

import com.app.app.domain.post.Pagination;
import com.app.app.domain.post.PostDTO;
import com.app.app.domain.post.PostVO;
import com.app.app.domain.post.Search;
import com.app.app.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

//    게시글 작성
    public void save(PostVO postVO) {
        postMapper.insert(postVO);
    }

//    게시글 전체 조회
    public List<PostDTO> findAll(Pagination pagination, Search search){
        return postMapper.selectAll(pagination, search);
    }

//    게시글 전체 개수 조회
    public int getTotal(){
        return postMapper.selectTotal();
    }

//    검색 결과 개수 조회
    public int getTotalWithSearch(Search search){
        return postMapper.selectTotalWithSearch(search);
    }

//    게시글 조회
    public Optional<PostDTO> findById(Long id){
        return postMapper.selectById(id);
    }

//    게시글 조회수 증가
    public void updatePostReadCount(Long id){
        postMapper.updatePostReadcount(id);
    }
}



















