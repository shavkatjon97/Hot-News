package shavkatjon.hotnews.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shavkatjon.hotnews.entity.base.AbsEntity;
import shavkatjon.hotnews.enums.IsMarriedStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_abouts")
public class UserAboutEntity extends AbsEntity {

    @OneToOne
    private User user;

    @Column(nullable = false)
    private String workPlace;

    private String birthPlace;

    @Column(nullable = false)
    private Timestamp birthDate;

    @Column(nullable = false)
    private Timestamp joinDate;


    private Timestamp closeDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_about_hobbies",
            joinColumns = @JoinColumn(name = "user_abouts_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id", referencedColumnName = "id"))
    private List<Hobby> userHobbies;

    @Enumerated(EnumType.STRING)
    private IsMarriedStatus marriedStatus;


}
