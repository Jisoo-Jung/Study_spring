package com.app.app.service.file;

import com.app.app.domain.file.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface FileService {
//    파일 추가
    public void register(FileVO fileVO);

//    파일 조회
    public FileVO getFile(Long id);

//    파일 목록
    public List<FileVO> getList(Long postId);

//    파일 삭제
    public void delete(Long id);

//    게시글 삭제 시, 해당 파일 전체 삭제
    public void deleteAll(Long postId);
}
