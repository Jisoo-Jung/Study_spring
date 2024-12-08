package com.app.threetier.controller.post;

import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.domain.post.*;
import com.app.threetier.service.post.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/post/*")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;
    private final HttpSession session;

    @GetMapping("write")
    public void goToWriteForm(PostDTO postDTO){;}

    @PostMapping("write")
    public void write(PostDTO postDTO){
        postDTO.setMemberId(((MemberVO) session.getAttribute("member")).getId());

        postService.write(postDTO.toVO());
    }

    @GetMapping("list")
    public void getList(Pagination pagination, Search search, Model model){
        if(pagination.getOrder() == null){
            pagination.setOrder("recent");
        }
        if(search.getKeyword() != null || search.getTypes() != null) {
            pagination.setTotal(postService.getTotalWithSearch(search));
        }else{
            pagination.setTotal(postService.getTotal());
        }
        pagination.progress();
        model.addAttribute("posts", postService.getList(pagination, search));
    }

    @GetMapping("read")
    public void read(Long id, Model model){
        PostDTO postDTO = postService.getPost(id).orElseThrow();
        model.addAttribute("post", postDTO);
    }

    @GetMapping("test")
    public void test(String[] tests){
        Arrays.stream(tests).forEach(log::info);
    }

    @PostMapping("test")
    public void test(TestDTO testDTO){
        log.info(testDTO.toString());
    }
}

















