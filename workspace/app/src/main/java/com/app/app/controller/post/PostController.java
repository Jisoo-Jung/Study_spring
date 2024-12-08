package com.app.app.controller.post;

import com.app.app.domain.file.FileDTO;
import com.app.app.domain.member.MemberVO;
import com.app.app.domain.post.*;
import com.app.app.service.post.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public void write(PostDTO postDTO, List<MultipartFile> files){
        postDTO.setMemberId(((MemberVO) session.getAttribute("member")).getId());
        List<FileDTO> fileDTOs = new ArrayList<>();

//        for(int i=0; i<files.size(); i++){
//            FileDTO fileDTO = new FileDTO();
//            fileDTO.setPostId(postDTO.getId());
//            fileDTO.setFileName(files.get(i).getOriginalFilename());
//            fileDTOs.add(fileDTO);
//        }

//        postService.write(postDTO.toVO(), fileDTOs.stream().map(FileDTO::toVO).collect(Collectors.toList()));
//        postService.write(postDTO, files);
    }

    @GetMapping("list")
    public void getList(Pagination pagination, Search search, Model model, HttpServletRequest request){
        log.info((String)request.getAttribute("data"));
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

















