package shavkatjon.hotnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shavkatjon.hotnews.entity.AttachmentContent;


import java.util.UUID;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {
}
