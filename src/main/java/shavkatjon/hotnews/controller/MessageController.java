package shavkatjon.hotnews.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shavkatjon.hotnews.payload.dto.MessageDto;
import shavkatjon.hotnews.projection.MessageProjection;
import shavkatjon.hotnews.service.MessagesService;

import java.util.List;

import static java.util.UUID.fromString;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/message")
public class MessageController {
    @GetMapping("/{receiverId}")
    public HttpEntity<?> getMessages(@PathVariable String receiverId) {

        List<MessageProjection> messages = messagesService.getAllMessagesByReciverId((receiverId));
        return ResponseEntity.status(messages != null ? HttpStatus.FOUND : HttpStatus.NOT_FOUND).body(messages);

    }

    final MessagesService messagesService;


    @GetMapping("/{senderId}/{receiverId}")
    public HttpEntity<?> getMessages(@PathVariable String senderId, @PathVariable String receiverId) {
        List<MessageProjection> messages = messagesService.getAllMessagesByReciverIdAndSenderId(fromString(receiverId), fromString(senderId));
        return ResponseEntity.ok(messages);

    }


    @GetMapping
    public HttpEntity getAllMessages(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "title") String sort,
            @RequestParam(defaultValue = "true") boolean direction) {
        return messagesService.getAllMessages(size, page, search, sort, direction);
    }


    @PostMapping()
    public HttpEntity publishPost(@RequestPart(name = "dto") MessageDto messageDto,
                                  @RequestPart(name = "files") List<MultipartFile> files) {
        return messagesService.sendMessages(messageDto, files);
    }

}
