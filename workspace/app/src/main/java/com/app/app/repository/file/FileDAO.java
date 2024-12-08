package com.app.app.repository.file;

import com.app.app.domain.file.FileVO;
import com.app.app.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

//    파일 추가
    public void save(FileVO fileVO){
        fileMapper.insert(fileVO);
    }

//    파일 조회
    public FileVO findById(Long id){
        return fileMapper.selectById(id);
    }

//    파일 목록
    public List<FileVO> findAll(Long postId){
        return fileMapper.selectAll(postId);
    }

//    파일 삭제
    public void delete(Long id){
        fileMapper.delete(id);
    }

//    게시글 삭제 시, 해당 파일 전체 삭제
    public void deleteByPostId(Long postId){
        fileMapper.deleteByPostId(postId);
    }
}
