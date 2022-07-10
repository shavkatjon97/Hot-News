package shavkatjon.hotnews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import shavkatjon.hotnews.entity.Attachment;
import shavkatjon.hotnews.entity.AttachmentContent;
import shavkatjon.hotnews.repository.AttachmentContentRepository;
import shavkatjon.hotnews.repository.AttachmentRepository;

import java.io.IOException;


@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    public Attachment saveAttachment(MultipartFile file) {

        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setContentType(file.getContentType());
        attachment.setSize(file.getSize());
        Attachment coverImage = attachmentRepository.save(attachment);

        AttachmentContent fileAttachment = new AttachmentContent();
        fileAttachment.setAttachment(coverImage);
        try {
            fileAttachment.setData(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        attachmentContentRepository.save(fileAttachment);

        return attachment;
    }
}
