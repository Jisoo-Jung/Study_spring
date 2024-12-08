package com.app.app.mapper;

import com.app.app.domain.post.Pagination;
import com.app.app.domain.post.PostDTO;
import com.app.app.domain.post.PostVO;
import com.app.app.domain.post.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
//    게시글 작성
    public void insert(PostVO postVO);
//    게시글 전체 조회
    public List<PostDTO> selectAll(@Param("pagination") Pagination pagination, @Param("search")Search search);
//    게시글 전체 개수 조회
    public int selectTotal();
//    검색 결과 개수 조회
    public int selectTotalWithSearch(@Param("search") Search search);
//    게시글 조회
    public Optional<PostDTO> selectById(Long id);
//    조회수 증가
    public void updatePostReadcount(Long id);
}
















