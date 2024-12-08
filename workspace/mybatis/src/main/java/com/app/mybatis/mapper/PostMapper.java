package com.app.mybatis.mapper;

import com.app.mybatis.domain.MemberVO;
import com.app.mybatis.domain.PostDTO;
import com.app.mybatis.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
//    게시글 작성
    public void insert(PostVO postVO);

//    게시글 목록
    public List<PostDTO> selectAll();

//    게시글 조회
    public PostDTO selectById(Long id);

//    게시글 수정
    public void update(PostVO postVO);

//    게시글 삭제
    public void softDelete(Long id);

//    조회수 증가
    public void increaseReadCount(Long id);

//    게시글 목록(최신순)
    public List<PostDTO> selectAllOrdered();
}




















