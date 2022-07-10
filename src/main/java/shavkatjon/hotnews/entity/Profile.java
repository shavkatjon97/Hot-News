package shavkatjon.hotnews.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shavkatjon.hotnews.entity.base.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "profiles")
public class Profile extends AbsEntity {

    @OneToOne
    User user;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String fullName;

    @OneToOne
    private Attachment attachment;
}
