package com.app.threetier.service.post;

import com.app.threetier.domain.post.Pagination;
import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;
import com.app.threetier.domain.post.Search;
import com.app.threetier.repository.post.PostDAO;
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

    @Override
    public void write(PostVO postVO) {
        postDAO.save(postVO);
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















