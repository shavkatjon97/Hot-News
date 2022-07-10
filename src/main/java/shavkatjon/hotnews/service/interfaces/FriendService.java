package shavkatjon.hotnews.service.interfaces;

import org.springframework.http.ResponseEntity;

public interface FriendService {

    ResponseEntity sendFriendRequest(String senderId, String receiverId);

    ResponseEntity acceptIgnoreRequest(String senderId, boolean isAccepted);

    ResponseEntity getUserFriendList(String userId);

}
