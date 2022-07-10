package shavkatjon.hotnews.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import shavkatjon.hotnews.payload.LikeDto;
import shavkatjon.hotnews.service.LikeService;

import java.util.UUID;

import static shavkatjon.hotnews.service.UserService.getCurrentUser;


@RestController
@RequestMapping("/api/likes")
public class LikeController {

    final
    LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/{postId}")
    public HttpEntity getPostLikes(@PathVariable String postId) {
        return likeService.getPostLikes(postId);
    }

    @PostMapping
    public HttpEntity addLike(@RequestBody LikeDto like) {
        UUID userId = getCurrentUser().getId();
        return likeService.saveOrDeleteLike(like, String.valueOf(userId));
    }

}
