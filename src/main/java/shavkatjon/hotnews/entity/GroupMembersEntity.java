package shavkatjon.hotnews.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shavkatjon.hotnews.entity.base.AbsEntity;
import shavkatjon.hotnews.enums.Role;


import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "group_members")
public class GroupMembersEntity extends AbsEntity {

    @ManyToOne
    private Channel channels;

    @ManyToOne
    private User channelMembers;

    @Enumerated(EnumType.STRING)
    Role role=Role.MEMBER;

}