package shavkatjon.hotnews.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shavkatjon.hotnews.enums.Chanel_GroupStatus;
import shavkatjon.hotnews.enums.Role;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChannelDto {
    private String name;

    @Enumerated(EnumType.STRING)
    private Chanel_GroupStatus status;

    @Enumerated(EnumType.STRING)
    private Role role;
}
