package shavkatjon.hotnews.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import shavkatjon.hotnews.entity.Comment;
import shavkatjon.hotnews.payload.ApiResponse;
import shavkatjon.hotnews.repository.CommentRepository;
import shavkatjon.hotnews.repository.PostRepository;
import shavkatjon.hotnews.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    final CommentRepository commentRepository;
    final UserRepository userRepository;
    final PostRepository postRepository;

//    public HttpEntity saveComment(CommentDto commentDto, String userId) {
//        Comment comment = new Comment();
//        comment.setUser(userRepository.findById(UUID.fromString(userId)).get());
//        comment.setBody(commentDto.getBody());
//        comment.setPost(postRepository.findById((UUID.fromString(commentDto.getPostId()).get());
//        commentRepository.save(comment);
//        ApiResponse res = new ApiResponse("success", true);
//        return ResponseEntity.ok(res);
//    }


    public HttpEntity getPostComments(String postId) {
        List<Comment> byPostId = commentRepository.findByPostId(UUID.fromString(postId));
        ApiResponse res = new ApiResponse("success", true, byPostId);
        return ResponseEntity.ok(res);
    }

    public HttpEntity deleteComment(String commentId) {
        commentRepository.deleteById(UUID.fromString(commentId));
        ApiResponse res = new ApiResponse("success", true);
        return ResponseEntity.ok(res);
    }
}
