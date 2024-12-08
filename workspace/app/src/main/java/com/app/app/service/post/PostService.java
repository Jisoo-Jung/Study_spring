package com.app.app.service.post;

import com.app.app.domain.file.FileVO;
import com.app.app.domain.post.Pagination;
import com.app.app.domain.post.PostDTO;
import com.app.app.domain.post.PostVO;
import com.app.app.domain.post.Search;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public void write(PostVO postVO, List<FileVO> files);
    public List<PostDTO> getList(Pagination pagination, Search search);
    public int getTotal();
    public int getTotalWithSearch(Search search);
    public Optional<PostDTO> getPost(Long id);
}
