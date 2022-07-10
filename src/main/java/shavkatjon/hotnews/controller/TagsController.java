package shavkatjon.hotnews.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shavkatjon.hotnews.entity.TagEntity;
import shavkatjon.hotnews.payload.ApiResponse;
import shavkatjon.hotnews.repository.TagRepository;
import shavkatjon.hotnews.service.TagService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tags")
public class TagsController {

    final TagService tagService;
    final TagRepository tagRepository;

    @GetMapping
    public HttpEntity<?> getAllTags() {
        List<TagEntity> all = tagRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping()
    public HttpEntity<?> saveTags(@RequestBody List<TagEntity> tags) {
        ApiResponse apiResponse = tagService.addTags(tags);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping("/{hobbyId}")
    public HttpEntity<?> getAllTagsByHobbyId(@PathVariable String hobbyId) {
        List<TagEntity> tagsByHobbyId = tagService.getTagsByHobbyId(UUID.fromString((hobbyId)));
        return ResponseEntity.ok(tagsByHobbyId);
    }
}

