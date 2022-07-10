package shavkatjon.hotnews.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import shavkatjon.hotnews.entity.Like;
import shavkatjon.hotnews.payload.ApiResponse;
import shavkatjon.hotnews.payload.LikeDto;
import shavkatjon.hotnews.repository.LikeRepository;
import shavkatjon.hotnews.repository.PostRepository;
import shavkatjon.hotnews.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LikeService {

    final LikeRepository likeRepository;

    final UserRepository userRepository;
    final PostRepository postRepository;

    public HttpEntity saveOrDeleteLike(LikeDto likeDto, String userId) {
        Optional<Like> like1 = likeRepository.findByUserIdAndPostId(UUID.fromString(userId), likeDto.getPostId());
        if (like1.isPresent()) {
            likeRepository.delete(like1.get());
        } else {
            Like like = new Like();
            like.setUser(userRepository.findById(UUID.fromString(((userId)))).get());
            like.setPost(postRepository.findById(likeDto.getPostId()).get());
            like.setTypes(likeDto.getLikeType());
            likeRepository.save(like);
        }
        ApiResponse res = new ApiResponse("success", true);
        return ResponseEntity.ok(res);
    }

    public HttpEntity getPostLikes(String postId) {
        List<Like> byPostId = likeRepository.findByPostId(UUID.fromString(postId));
        ApiResponse res = new ApiResponse("success", true, byPostId);
        return ResponseEntity.ok(res);
    }
}
