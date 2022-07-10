package shavkatjon.hotnews.projection;

import org.springframework.data.rest.core.config.Projection;
import shavkatjon.hotnews.entity.MessageEntity;

import java.util.UUID;

@Projection(types = MessageEntity.class)
public interface MessageProjection {

    UUID getSenderId();

    String getMessageBody();

    UUID getAttachmentId();

}
