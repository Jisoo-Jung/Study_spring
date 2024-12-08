package com.app.app.service.post;

import com.app.app.domain.file.FileVO;
import com.app.app.domain.post.Pagination;
import com.app.app.domain.post.PostDTO;
import com.app.app.domain.post.PostVO;
import com.app.app.domain.post.Search;
import com.app.app.repository.file.FileDAO;
import com.app.app.repository.post.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;
    private final FileDAO fileDAO;

    @Override
    public void write(PostVO postVO, List<FileVO> files) {
        postDAO.save(postVO);
        files.forEach(file -> {
           fileDAO.save(file);
        });
    }

    @Override
    public List<PostDTO> getList(Pagination pagination, Search search) {
        return postDAO.findAll(pagination, search);
    }

    @Override
    public int getTotal() {
        return postDAO.getTotal();
    }

    @Override
    public int getTotalWithSearch(Search search) {
        return postDAO.getTotalWithSearch(search);
    }

    @Override
    public Optional<PostDTO> getPost(Long id) {
        postDAO.updatePostReadCount(id);
        return postDAO.findById(id);
    }
}















