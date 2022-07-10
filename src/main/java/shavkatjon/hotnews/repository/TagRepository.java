package shavkatjon.hotnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shavkatjon.hotnews.entity.TagEntity;

import java.util.List;
import java.util.UUID;

public interface TagRepository extends JpaRepository<TagEntity, UUID> {

    @Query(nativeQuery = true, value = "\n" +
            "select t.name from tags t join hobbies_tags ht on t.id = ht.tags_id\n" +
            "where hobbies_id=:hobbyId")
    List<TagEntity> findByHobbyId(UUID hobbyId);

//    @Query(nativeQuery = true,value = "\n" +
//            "select t.name from tags t join hobbies_tags ht on t.id = ht.tags_id\n" +
//            "where ht=:hobbyName")
//    List<TagEntity> findByHobbyAndName(String hobbyName);

}
