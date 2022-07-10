package shavkatjon.hotnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shavkatjon.hotnews.entity.MessageEntity;
import shavkatjon.hotnews.projection.MessageProjection;

import java.util.List;
import java.util.UUID;

public interface MessagesRepository extends JpaRepository<MessageEntity, UUID> {

    @Query(nativeQuery = true, value = "select  cast(m.sender_id as varchar) as id, cast(t.attachments_id as varchar) as attachments_id,m.body  from messages m\n" +
            "    join (select * from messages_attachments join attachments a on a.id = messages_attachments.attachments_id) t\n" +
            "    on m.id=t.messages_id\n" +
            "where m.reciver_id=:reciverId\n" +
            "order by m.created_at")
    List<MessageProjection> findByReciverId(UUID reciverId);


    @Query(nativeQuery = true, value = "select cast(m.sender_id as varchar) as id,cast(t.attachments_id as varchar) as attachments_id,m.body from messages m\n" +
            "    join (select * from messages_attachments join attachments a on a.id = messages_attachments.attachments_id) t\n" +
            "    on m.id=t.messages_id\n" +
            "where m.reciver_id=:reciverId and m.sender_id=:senderId\n" +
            "order by m.created_at")
    List<MessageProjection> findByReciverIdAndSenderId(UUID reciverId, UUID senderId);
}
