package shavkatjon.hotnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shavkatjon.hotnews.entity.Friend;
import shavkatjon.hotnews.entity.User;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FriendRepository extends JpaRepository<Friend, UUID> {

    List<Friend> findByReceiverAndStatus(User receiver, String status);

    Optional<Friend> findBySenderAndReceiver(User sender, User receiver);

}
