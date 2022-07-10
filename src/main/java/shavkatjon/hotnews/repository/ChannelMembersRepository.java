package shavkatjon.hotnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shavkatjon.hotnews.entity.ChannelMembersEntity;

import java.util.UUID;

public interface ChannelMembersRepository extends JpaRepository<ChannelMembersEntity, UUID> {

}
