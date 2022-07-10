package shavkatjon.hotnews.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import shavkatjon.hotnews.entity.base.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tags")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TagEntity extends AbsEntity {

    @Column(nullable = false)
    private String name;
}
