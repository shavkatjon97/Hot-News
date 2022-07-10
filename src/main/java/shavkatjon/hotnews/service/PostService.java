package shavkatjon.hotnews.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import shavkatjon.hotnews.entity.Attachment;
import shavkatjon.hotnews.entity.Post;
import shavkatjon.hotnews.payload.ApiResponse;
import shavkatjon.hotnews.payload.dto.PostDto;
import shavkatjon.hotnews.projection.PostProjection;
import shavkatjon.hotnews.repository.PostRepository;
import shavkatjon.hotnews.repository.ProfileRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    final PostRepository postRepository;

    final ProfileRepository profileRepository;

    final AttachmentService attachmentService;

    public HttpEntity getMyPosts(String profileId) {
        List<Post> posts = postRepository.findByProfileId(UUID.fromString(profileId));
        ApiResponse res = new ApiResponse("success", true, posts);
        return ResponseEntity.ok(res);
    }

    public HttpEntity publishPost(PostDto postDto, List<MultipartFile> files) {
        Post post = new Post();
        List<Attachment> attachments = new ArrayList<>();
        for (MultipartFile file : files) {
            Attachment attachment = attachmentService.saveAttachment(file);
            attachments.add(attachment);
        }
        post.setAttachments(attachments);
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        if (postDto.getProfileId() != null) {
            post.setProfile(profileRepository.findById(postDto.getProfileId()).get());
        }
        postRepository.save(post);
        ApiResponse res = new ApiResponse("success", true, null);
        return ResponseEntity.ok(res);
    }

    public HttpEntity deletePost(String postId, String profileId) {
        if (postRepository.findById(UUID.fromString(postId)).get().getProfile().getId().equals(profileId)) {
            postRepository.deleteById(UUID.fromString(postId));
            ApiResponse res = new ApiResponse("success", true);

            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    public HttpEntity getPosts(String profileId) {
        List<Post> all = postRepository.findAll();
        ApiResponse res = new ApiResponse("success", true, all);
        return new ResponseEntity(res, HttpStatus.OK);
    }

    public HttpEntity getPost(String postId) {
        PostProjection postById = postRepository.getPostById(UUID.fromString(postId));
        ApiResponse res = new ApiResponse("success", true, postById);
        return ResponseEntity.ok(res);
    }
}
