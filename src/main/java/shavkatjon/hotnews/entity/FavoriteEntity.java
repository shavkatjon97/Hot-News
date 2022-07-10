package shavkatjon.hotnews.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import shavkatjon.hotnews.entity.base.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "favorites")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FavoriteEntity extends AbsEntity {

    @ManyToOne
    User user;
}
