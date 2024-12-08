package com.app.threetier.controller.reply;

import com.app.threetier.domain.post.Pagination;
import com.app.threetier.domain.reply.ReplyDTO;
import com.app.threetier.service.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies/*")
@Slf4j
public class ReplyController {
    private final ReplyService replyService;

//    INSERT
    @PostMapping("write")
    public void write(@RequestBody ReplyDTO replyDTO){
        replyService.write(replyDTO.toVO());
    }

//    SELECT
    @GetMapping("{postId}/{page}")
    public List<ReplyDTO> getList(@PathVariable("postId") Long postId,
                        @PathVariable("page") int page,
                        Pagination pagination,
                        Model model){
        log.info("{}", page);
        pagination.setPage(page);
        pagination.setTotal(replyService.getTotal(postId));
        pagination.progress();
        log.info("{}", pagination.toString());

        return replyService.getReplies(pagination, postId);
    }

//    댓글 수정
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


















