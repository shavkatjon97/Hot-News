package shavkatjon.hotnews.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import shavkatjon.hotnews.entity.base.AbsEntity;


import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "attachments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Attachment extends AbsEntity {

    String name;
    String contentType;
    Long size;
}
