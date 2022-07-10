package shavkatjon.hotnews.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import shavkatjon.hotnews.entity.base.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "posts")
public class Post extends AbsEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private Timestamp date;

    @ManyToOne
    private Profile profile;

    @OneToMany
    private List<Attachment> attachments;

    @ManyToOne
    private FavoriteEntity favorite;
}
