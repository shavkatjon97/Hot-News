package shavkatjon.hotnews.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import shavkatjon.hotnews.entity.base.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "comments")


public class Comment extends AbsEntity {

    @ManyToOne
    User user;

    @Column(nullable = false)
    String body;

    @ManyToOne
    Post post;

    Timestamp writeDate;

}
