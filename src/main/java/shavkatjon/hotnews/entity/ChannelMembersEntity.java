package shavkatjon.hotnews.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import shavkatjon.hotnews.enums.Role;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "channel_members")
public class ChannelMembersEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column
    private UUID channelMemberId;

    @Column
    private UUID channelId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Role role=Role.MEMBER;
}
