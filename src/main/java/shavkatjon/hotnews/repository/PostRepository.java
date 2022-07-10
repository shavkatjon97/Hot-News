package shavkatjon.hotnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shavkatjon.hotnews.entity.Post;
import shavkatjon.hotnews.projection.PostProjection;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findByProfileId(UUID profileId);

    @Query(nativeQuery = true, value = "select p.* from posts p\n" +
            "join profiles pr on p.profile_id = pr.id\n" +
            "join users u on pr.user_id = u.id\n" +
            "join user_friends uf on u.id = uf.receiver_id or u.id = uf.sender_id\n" +
            "join channels c on cu.channels_id = c.id \n" +
            "join groups g on gu.groups_id = g.id\n" +
            "where pr.id = :profileId and uf.friends_request_status = 'ACCEPTED' or \n" +
            "      c.profile_id = p.profile_id or g.profile_id = p.profile_id\n" +
            "order by p.created_at ")
    List<Post> getOtherPosts(String profileId);

    @Query(nativeQuery = true, value = "select cast(p.id as varchar) as id, p.title, p.description from posts p")
    PostProjection getPostById(UUID id);
}
