package shavkatjon.hotnews.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import shavkatjon.hotnews.entity.Attachment;
import shavkatjon.hotnews.entity.MessageEntity;
import shavkatjon.hotnews.payload.ApiResponse;
import shavkatjon.hotnews.payload.dto.MessageDto;
import shavkatjon.hotnews.projection.MessageProjection;
import shavkatjon.hotnews.repository.MessagesRepository;
import shavkatjon.hotnews.repository.ProfileRepository;
import shavkatjon.hotnews.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessagesService {
    final MessagesRepository messagesRepository;
    final AttachmentService attachmentService;
    final ProfileRepository profileRepository;
    final UserRepository userRepository;


    public List<MessageProjection> getAllMessagesByReciverId(String id) {
        List<MessageProjection> byReciverId = messagesRepository.findByReciverId(UUID.fromString((id)));
        if (!byReciverId.isEmpty())
            return byReciverId;
        return null;
    }

    public List<MessageProjection> getAllMessagesByReciverIdAndSenderId(UUID reciverId, UUID senderID) {
        List<MessageProjection> messages = messagesRepository.findByReciverIdAndSenderId(reciverId, senderID);
        return messages;
    }


    public HttpEntity<?> sendMessages(MessageDto messageDto, List<MultipartFile> files) {

        MessageEntity message = new MessageEntity();
        List<Attachment> attachments = new ArrayList<>();
        for (MultipartFile file : files) {
            Attachment attachment = attachmentService.saveAttachment(file);
            attachments.add(attachment);
        }
        message.setAttachments(attachments);
        message.setBody(messageDto.getBody());
        if (messageDto.getSender() != null && messageDto.getReceiver() != null) {
            message.setReciver(userRepository.findById(UUID.fromString(String.valueOf(messageDto.getReceiver()))).get());
            message.setSender(userRepository.findById(UUID.fromString(String.valueOf(messageDto.getSender()))).get());
        }

        messagesRepository.save(message);
        ApiResponse res = new ApiResponse("success", true, null);
        return ResponseEntity.ok(res);

    }

    public HttpEntity getAllMessages(int size, int page, String search, String sort, boolean direction) {
        try {
            Pageable pageable = PageRequest.of(
                    page - 1,
                    size,
                    direction ? Sort.Direction.ASC : Sort.Direction.DESC,
                    sort
            );
            Page<MessageEntity> all = messagesRepository.findAll(pageable);
            return ResponseEntity.ok(new ApiResponse("success", true, all));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(
                    "error", false, null
            ));
        }
    }


}
