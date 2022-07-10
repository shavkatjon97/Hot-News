package shavkatjon.hotnews.payload.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserDto {

    @NotNull(message = "have to give phoneNumber")
    String phoneNumber;
    @NotNull(message = "have to give password")
    String password;
}
