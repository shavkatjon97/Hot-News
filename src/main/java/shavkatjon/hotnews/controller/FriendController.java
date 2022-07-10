package shavkatjon.hotnews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shavkatjon.hotnews.service.interfaces.FriendService;



@RestController
@RequestMapping("/api/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

//    @GetMapping
//    public ResponseEntity sendFriendRequest(@RequestBody String receiverId) {
//
//        return friendService.sendFriendRequest(getCurrentUser().getId(),receiverId);
//    }

//    @GetMapping("/accept-ignore")
//    public ResponseEntity acceptIgnoreRequest(@RequestBody FriendRequestDto friendRequestDto){
//        return friendService.acceptIgnoreRequest(friendRequestDto.getSenderId(), friendRequestDto.isAccepted());
//    }

//    @GetMapping("/friend-list")
//    public ResponseEntity acceptIgnoreRequest(){
//        return friendService.getUserFriendList(getCurrentUser().getId());
//    }
}
