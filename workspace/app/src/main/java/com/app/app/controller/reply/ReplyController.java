package com.app.app.controller.reply;

import com.app.app.domain.post.Pagination;
import com.app.app.domain.reply.ReplyDTO;
import com.app.app.domain.reply.ReplyListDTO;
import com.app.app.service.reply.ReplyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies/*")
@Slf4j
@Tag(name="Reply", description = "Reply RESTful API")
//http://localhost:10000/swagger-ui/index.html
public class ReplyController {
    private final ReplyService replyService;

//    INSERT
    @Operation(summary = "댓글 작성", description = "댓글 작성 시 사용하는 API")
    @PostMapping("write")
    public void write(@RequestBody ReplyDTO replyDTO){
        log.info("들어옴!!");
        log.info(replyDTO.toString());
        replyService.write(replyDTO.toVO());
    }

//    SELECT
    @Operation(summary = "댓글 목록", description = "댓글 목록 조회 시 사용하는 API")
    @GetMapping("{postId}/{page}")
    public ReplyListDTO getList(@PathVariable("postId") Long postId,
                                @PathVariable("page") int page,
                                Pagination pagination,
                                Model model){

        return replyService.getReplies(page, pagination, postId);
    }

//    댓글 수정m
//    Put: 전체 수정
//    Patch: 부분 수정
    @PutMapping("update")
    public void update(@RequestBody ReplyDTO replyDTO){
        replyService.setReply(replyDTO.toVO());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        replyService.delete(id);
    }
}


















