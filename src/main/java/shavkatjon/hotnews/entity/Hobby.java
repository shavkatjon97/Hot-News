package shavkatjon.hotnews.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shavkatjon.hotnews.entity.base.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "hobbies")
public class Hobby extends AbsEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany
    private List<TagEntity> tags;

}
