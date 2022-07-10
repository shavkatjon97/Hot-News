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
@Entity(name = "events")
public class Event extends AbsEntity {

    @ManyToOne
    UserAboutEntity userAbout;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    Timestamp startDate;

}
