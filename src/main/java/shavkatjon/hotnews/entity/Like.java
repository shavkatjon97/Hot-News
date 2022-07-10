package shavkatjon.hotnews.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import shavkatjon.hotnews.entity.base.AbsEntity;
import shavkatjon.hotnews.enums.LikesTypes;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "likes")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Like extends AbsEntity {
    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Enumerated(EnumType.STRING)
    LikesTypes types;

}
