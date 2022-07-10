package shavkatjon.hotnews.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shavkatjon.hotnews.entity.Hobby;
import shavkatjon.hotnews.entity.TagEntity;
import shavkatjon.hotnews.payload.ApiResponse;
import shavkatjon.hotnews.payload.dto.HobbyDto;
import shavkatjon.hotnews.repository.HobbiesRepository;
import shavkatjon.hotnews.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HobbiesService {
    final HobbiesRepository hobbiesRepository;
    final TagRepository tagRepository;


    public ApiResponse addHobbies(List<HobbyDto> hobbyDto) {
        for (HobbyDto hobby : hobbyDto) {
            Hobby hobby1 = new Hobby();
            hobby1.setName(hobby.getName());
            List<TagEntity> tagList = new ArrayList<>();
            for (UUID tags : hobby.getTagsId()) {
                tagList.add(tagRepository.findById(tags).get());
            }
            hobby1.setTags(tagList);
            hobbiesRepository.save(hobby1);
        }
        return new ApiResponse("hobbies add", true);
    }


}
