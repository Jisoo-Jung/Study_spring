package com.app.app.mapper;

import com.app.app.domain.file.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
//    파일 추가
    public void insert(FileVO fileVO);

//    파일 조회
    public FileVO selectById(Long id);

//    파일 목록
    public List<FileVO> selectAll(Long postId);

//    파일 삭제
    public void delete(Long id);

//    게시글 삭제 시, 해당 파일 전체 삭제
    public void deleteByPostId(Long postId);
}
