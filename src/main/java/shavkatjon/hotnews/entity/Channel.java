package shavkatjon.hotnews.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import shavkatjon.hotnews.entity.base.AbsEntity;
import shavkatjon.hotnews.enums.Chanel_GroupStatus;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "channels")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Channel extends AbsEntity {

    @Column(nullable = false)
    String name;

    @ManyToOne
    Profile profile;

    @Enumerated(EnumType.STRING)
    Chanel_GroupStatus status = Chanel_GroupStatus.ACTIVE_AND_PUBLIC;
}
