package shavkatjon.hotnews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import shavkatjon.hotnews.service.CommentService;


@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/{postId}")
    public HttpEntity getPostComments(@PathVariable String postId) {
        return commentService.getPostComments(postId);
    }
//
//    @PostMapping
//    public HttpEntity writeComment(@RequestBody CommentDto comment) {
//        String userId = "1";
//        return commentService.saveComment(comment, userId);
//    }

    @DeleteMapping("/{commentId}")
    public HttpEntity deleteComment(@PathVariable String commentId) {
        return commentService.deleteComment(commentId);
    }
}
