package shavkatjon.hotnews.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data

//Asatbek Xalimojnov 4/13/22 5:45 PM

public class FriendRequestDto {

    private UUID senderId;
    private UUID receiverId;
    private boolean isAccepted;
}
