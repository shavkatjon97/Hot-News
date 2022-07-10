package shavkatjon.hotnews.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shavkatjon.hotnews.payload.ApiResponse;
import shavkatjon.hotnews.payload.dto.HobbyDto;
import shavkatjon.hotnews.service.HobbiesService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hobbies")
public class HobbyController {
    final HobbiesService hobbiesService;

    @PostMapping()
    public HttpEntity<?> saveHobbies(@RequestBody List<HobbyDto> hobbyDto) {
        ApiResponse apiResponse = hobbiesService.addHobbies(hobbyDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
