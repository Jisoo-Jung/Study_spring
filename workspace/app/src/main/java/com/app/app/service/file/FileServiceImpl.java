package com.app.app.service.file;

import com.app.app.domain.file.FileVO;
import com.app.app.repository.file.FileDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileDAO fileDAO;

    @Override
    public void register(FileVO fileVO) {
        fileDAO.save(fileVO);
    }

    @Override
    public FileVO getFile(Long id) {
        return fileDAO.findById(id);
    }

    @Override
    public List<FileVO> getList(Long postId) {
        return fileDAO.findAll(postId);
    }

    @Override
    public void delete(Long id) {
        fileDAO.delete(id);
    }

    @Override
    public void deleteAll(Long postId) {
        fileDAO.deleteByPostId(postId);
    }
}
