package com.app.mybatis.controller;

import com.app.mybatis.domain.PostDTO;
import com.app.mybatis.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post/*")
@RequiredArgsConstructor
public class PostController {
    private final PostMapper postMapper;

//    게시글 작성
    @GetMapping("write")
    public void write(PostDTO postDTO){
        postMapper.insert(postDTO.toVO());
    }

//    게시글 목록
    @GetMapping("list")
    public void list(Model model){
        model.addAttribute("posts", postMapper.selectAll());
    }

//    게시글 조회
    @GetMapping("read")
    public void read(Long id, Model model){
        postMapper.increaseReadCount(id);
        model.addAttribute("post", postMapper.selectById(id));
    }

//    게시글 수정
    @GetMapping("update")
    public void update(PostDTO postDTO){
        postMapper.update(postDTO.toVO());

    }
//    게시글 삭제
    @GetMapping("delete")
    public void delete(Long id){
        postMapper.softDelete(id);
    }

//    게시글 목록(최신순)
    @GetMapping("list/order")
    public void listOrdered(Model model){
        model.addAttribute("posts", postMapper.selectAllOrdered());
    }
}

















