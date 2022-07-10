package shavkatjon.hotnews.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shavkatjon.hotnews.entity.TagEntity;
import shavkatjon.hotnews.payload.ApiResponse;
import shavkatjon.hotnews.repository.TagRepository;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class TagService {
    final TagRepository tagRepository;


    public List<TagEntity> getTagsByHobbyId(UUID hobbyId) {
        return tagRepository.findByHobbyId(hobbyId);
    }

    public ApiResponse addTags(List<TagEntity> tags) {

        for (TagEntity tag : tags) {
            TagEntity tagEntity = new TagEntity();
            tagEntity.setName(tag.getName());
            tagRepository.save(tagEntity);
        }
        return new ApiResponse("tags add", true);
    }


}
