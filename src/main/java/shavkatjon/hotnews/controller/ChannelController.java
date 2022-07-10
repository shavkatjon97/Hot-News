package shavkatjon.hotnews.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shavkatjon.hotnews.service.ChannelService;

@RestController
@RequestMapping("/api/channel")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

//    @GetMapping("/all")
//    public HttpEntity<?> getAllChannel() {
//        return ResponseEntity.ok(channelService.getAllChannel());
//    }
//
//    @GetMapping("/name")
//    public HttpEntity<?> getChannelByName(String name) {
//        ApiResponse channelByUserName = channelService.getChannelByUserName(name);
//        return ResponseEntity.status(channelByUserName.isSuccess() ? HttpStatus.FOUND : HttpStatus.NOT_FOUND).body(channelByUserName);
//    }
//
//    @PostMapping("/create")
//    public HttpEntity<?> createChannel(@RequestBody UUID userId, @RequestBody ChannelDto channelDto) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(channelService.createChannel(userId, channelDto));
//    }
//
//    @PutMapping("/edit/{id}")
//    public HttpEntity<?> editGroup(@PathVariable UUID id, @RequestBody ChannelDto channelDto) {
//        ApiResponse apiResponse = channelService.editChannelData(id, channelDto);
//        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public HttpEntity<?> deleteChannel(@PathVariable UUID id) {
//        ApiResponse apiResponse = channelService.deleteChannel(id);
//        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse);
//    }
//
//    @PostMapping("/join{userId}")
//    public HttpEntity<?> joinChannel(@PathVariable UUID id, UUID userId) {
//        ApiResponse apiResponse = channelService.joinChannel(id, userId);
//        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
//    }
//
//    @PostMapping("/promote/{id}")
//    public HttpEntity<?> promoteUser(@PathVariable UUID id, @RequestBody Role role) {
//        ApiResponse apiResponse = channelService.promoteUser(id, role);
//        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse);
//    }
//
//    @DeleteMapping("/remove/user/{id}")
//    public HttpEntity<?> removeUser(@PathVariable UUID id) {
//        ApiResponse apiResponse = channelService.removeUserFromChannel(id);
//        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse);
//    }
}
