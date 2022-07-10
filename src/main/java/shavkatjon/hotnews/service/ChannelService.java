package shavkatjon.hotnews.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shavkatjon.hotnews.entity.Channel;
import shavkatjon.hotnews.entity.ChannelMembersEntity;
import shavkatjon.hotnews.entity.User;
import shavkatjon.hotnews.enums.Chanel_GroupStatus;
import shavkatjon.hotnews.enums.Role;
import shavkatjon.hotnews.payload.ApiResponse;
import shavkatjon.hotnews.payload.dto.ChannelDto;
import shavkatjon.hotnews.repository.ChannelMembersRepository;
import shavkatjon.hotnews.repository.ChannelsRepository;
import shavkatjon.hotnews.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChannelService {
    private final ChannelsRepository channelsRepository;
    private final ChannelMembersRepository channelMembersRepository;
    private final UserRepository userRepository;


    public ApiResponse createChannel(UUID userId, ChannelDto channelDto) {
        Channel channel = new Channel();
        ChannelMembersEntity entity = new ChannelMembersEntity();

        channelsRepository.save(channelBase(channelDto, channel));
        entity.setChannelMemberId(userId);
        entity.setChannelId(channel.getId());
        entity.setRole(Role.OWNER);

        channelMembersRepository.save(entity);
        return new ApiResponse("Channel Created", true);
    }

    public ApiResponse getAllChannel() {
        List<Channel> all = channelsRepository.findAll();
        return new ApiResponse("All channels", true, all);
    }

    public ApiResponse getChannelByUserName(String name) {
        boolean channelByNameContains = channelsRepository.findChannelByNameContains(name);
        if (channelByNameContains) return new ApiResponse("Channel found", true);
        return new ApiResponse("Not found", false);
    }

    public ApiResponse editChannelData(UUID id, ChannelDto channelDto) {
        Optional<Channel> byId = channelsRepository.findById(id);
        if (byId.isPresent()) {
            Channel channel = byId.get();
            channelBase(channelDto, channel);
            return new ApiResponse("edited", true);
        }
        return new ApiResponse("Not found", false);
    }

    public ApiResponse deleteChannel(UUID id) {
        boolean b = channelsRepository.existsById(id);
        if (b) {
            channelsRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        }
        return new ApiResponse("Not Found", false);
    }

    public ApiResponse joinChannel(UUID id, UUID userId) {
        ChannelMembersEntity entity = new ChannelMembersEntity();

        Optional<Channel> byId = channelsRepository.findById(id);
        Channel channel = byId.get();

        Chanel_GroupStatus byState = Chanel_GroupStatus.getByState(1);

        if (channel.getStatus().equals(Chanel_GroupStatus.getByState(0))) {
            entity.setChannelMemberId(userId);
            entity.setChannelId(channel.getId());
        } else if (channel.getStatus().equals(Chanel_GroupStatus.getByState(1))) {

        }
        channelMembersRepository.save(entity);
        return new ApiResponse("You are joined", true);
    }

    public ApiResponse promoteUser(UUID id, Role role) {
        Optional<User> b = userRepository.findById(id);
        if (b.isPresent()) {
            ChannelMembersEntity entity = new ChannelMembersEntity();

            entity.setChannelMemberId(b.get().getId());
            entity.setRole(role);
            channelMembersRepository.save(entity);
            return new ApiResponse("User promoted to " + role.toString(), true);
        }
        return new ApiResponse("User Not Found", false);
    }

    public ApiResponse removeUserFromChannel(UUID id) {
        Optional<User> byId = userRepository.findById(id);
        User user = byId.get();
        Optional<ChannelMembersEntity> byId1 = channelMembersRepository.findById(user.getId());

        if (byId1.isPresent()) {
            channelMembersRepository.deleteById(id);
            return new ApiResponse("Deleted", true);
        }
        return new ApiResponse("Not found", false);
    }

//    public User sendJoinRequest(String id) {
//
//    }

    private Channel channelBase(ChannelDto channelDto, Channel channel) {
        channel.setName(channelDto.getName());
        channel.setStatus(channelDto.getStatus());
        return channel;
    }

}
