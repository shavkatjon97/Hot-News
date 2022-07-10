package shavkatjon.hotnews.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shavkatjon.hotnews.payload.dto.PostDto;
import shavkatjon.hotnews.repository.ProfileRepository;
import shavkatjon.hotnews.service.PostService;

import java.util.List;

import static shavkatjon.hotnews.service.UserService.getCurrentUser;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    final
    ProfileRepository profileRepository;
    final
    PostService postService;

    public PostController(ProfileRepository profileRepository, PostService postService) {
        this.profileRepository = profileRepository;
        this.postService = postService;
    }

    @GetMapping("/get-my-posts")
    public HttpEntity getMyPosts() {
        String profileId = String.valueOf(profileRepository.findByUserId(getCurrentUser().getId()).getId());
        return postService.getMyPosts(profileId);
    }

    @GetMapping("/{postId}")
    public HttpEntity getPost(@PathVariable String postId) {
        return postService.getPost(postId);
    }

    @PostMapping
    public HttpEntity publishPost(@RequestPart(name = "dto") PostDto postDto,
                                  @RequestPart(name = "files") List<MultipartFile> files) {
        return postService.publishPost(postDto, files);
    }

    @DeleteMapping("{postId}")
    public HttpEntity deletePost(@PathVariable String postId) {
        String profileId = String.valueOf(profileRepository.findByUserId(getCurrentUser().getId()).getId());
        return postService.deletePost(postId, profileId);
    }

}
