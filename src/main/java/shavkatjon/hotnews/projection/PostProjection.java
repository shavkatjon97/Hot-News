package shavkatjon.hotnews.projection;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import shavkatjon.hotnews.entity.Comment;
import shavkatjon.hotnews.entity.Like;
import shavkatjon.hotnews.entity.Post;

import java.util.List;
import java.util.UUID;

@Projection(types = Post.class)
public interface PostProjection {
    UUID getId();

    String getTitle();

    String getDescription();

    @Value("#{@commentRepository.findByPostId(target.id)}")
    List<Comment> getComments();

    @Value("#{@likeRepository.findByPostId(target.id)}")
    List<Like> getLikes();
}
