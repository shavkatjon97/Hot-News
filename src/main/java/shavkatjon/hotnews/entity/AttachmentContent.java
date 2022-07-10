package shavkatjon.hotnews.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import shavkatjon.hotnews.entity.base.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "attachment_content")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AttachmentContent extends AbsEntity {

    @OneToOne
    Attachment attachment;
    byte[] data;
}
