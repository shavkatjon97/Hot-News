package shavkatjon.hotnews.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import shavkatjon.hotnews.entity.Friend;
import shavkatjon.hotnews.entity.User;
import shavkatjon.hotnews.payload.ApiResponse;
import shavkatjon.hotnews.repository.FriendRepository;
import shavkatjon.hotnews.repository.UserRepository;
import shavkatjon.hotnews.service.interfaces.FriendService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static shavkatjon.hotnews.enums.FriendsRequestStatus.*;
import static shavkatjon.hotnews.service.UserService.getCurrentUser;


//Asatbek Xalimojnov 4/13/22 3:01 PM


@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService {

    private final FriendRepository friendRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity sendFriendRequest(String senderId, String receiverId) {

        String message = "";
        boolean success = false;
        HttpStatus status = null;

        if (userRepository.findById(UUID.fromString(senderId)).isPresent() && userRepository.findById(UUID.fromString(receiverId)).isPresent()) {

            try {
                Friend friend = new Friend();
                friend.setReceiver(userRepository.findById(UUID.fromString(receiverId)).get());
                friend.setSender(userRepository.findById(UUID.fromString(senderId)).get());
                friend.setStatus(IN_PROGRESS);

                friendRepository.save(friend);
                success = true;
                message = "created";
                status = HttpStatus.CREATED;
            } catch (Exception e) {
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            message = "receiver or sender user not found";
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(new ApiResponse(message, success, null), status);
    }

    @Override
    public ResponseEntity acceptIgnoreRequest(String senderId, boolean isAccepted) {

        String message = "";
        boolean success = false;
        HttpStatus status = null;

        if (userRepository.findById(UUID.fromString(senderId)).isPresent()) {

            User sender = userRepository.findById(UUID.fromString(senderId)).get();
            if (friendRepository.findBySenderAndReceiver(sender, getCurrentUser()).isPresent()) {
                try {
                    Friend friend = friendRepository.findBySenderAndReceiver(sender, getCurrentUser()).get();
                    friend.setStatus(isAccepted ? ACCEPTED : REJECTED);
                    friendRepository.save(friend);
                    message = "success";
                    success = true;
                    status = HttpStatus.OK;
                } catch (Exception e) {
                    message = "error";
                    status = HttpStatus.INTERNAL_SERVER_ERROR;
                }
            }
        } else {
            status = HttpStatus.NOT_FOUND;
            message = "error";
        }

        return new ResponseEntity<>(new ApiResponse(message, success, null), status);
    }

    @Override
    public ResponseEntity getUserFriendList(String userId) {

        List<Friend> friendList = friendRepository.findAll()
                .stream()
                .filter(
                        user ->
                                (user.getReceiver().getId().equals(userId) && user.getStatus().equals(ACCEPTED))
                                        || (user.getSender().getId().equals(userId) && user.getStatus().equals(ACCEPTED)))
                .collect(Collectors.toList());

        return new ResponseEntity<>(new ApiResponse("success", true, friendList), HttpStatus.OK);
    }


}
