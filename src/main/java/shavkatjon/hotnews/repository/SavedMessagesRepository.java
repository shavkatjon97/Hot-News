package shavkatjon.hotnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shavkatjon.hotnews.entity.SavedMessage;

import java.util.UUID;

public interface SavedMessagesRepository extends JpaRepository<SavedMessage, UUID> {

}
