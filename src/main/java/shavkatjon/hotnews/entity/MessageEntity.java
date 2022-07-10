package shavkatjon.hotnews.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import shavkatjon.hotnews.entity.base.AbsEntity;


import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "messages")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageEntity extends AbsEntity {

    @OneToOne
    User sender;

    @Column(nullable = false)
    String body;

    @OneToMany
    List<Attachment> attachments;

    @OneToOne
    User reciver;

    @ManyToOne
    FavoriteEntity favorite;

    @ManyToOne
    SavedMessage savedMessage;
}
