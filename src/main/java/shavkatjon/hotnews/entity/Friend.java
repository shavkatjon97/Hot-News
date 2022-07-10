package shavkatjon.hotnews.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import shavkatjon.hotnews.entity.base.AbsEntity;
import shavkatjon.hotnews.enums.FriendsRequestStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data


@Entity(name = "user_friends")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Friend extends AbsEntity {

    @ManyToOne
    User sender;

    @ManyToOne
    User receiver;

    @Enumerated(EnumType.STRING)
    FriendsRequestStatus status;
}
