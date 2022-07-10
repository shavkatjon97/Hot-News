package shavkatjon.hotnews.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import shavkatjon.hotnews.entity.base.AbsEntity;
import shavkatjon.hotnews.enums.Chanel_GroupStatus;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "groups")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group extends AbsEntity {
    @ManyToOne
    Profile profile;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "groups_users",
            joinColumns = @JoinColumn(name = "groups_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    List<User> userList;

    @ManyToOne
    FavoriteEntity favorite;

    @Enumerated(EnumType.STRING)
    Chanel_GroupStatus status;
}
