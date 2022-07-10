package shavkatjon.hotnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shavkatjon.hotnews.entity.Group;

import java.util.UUID;

@Repository
public interface GroupsRepository extends JpaRepository<Group, UUID> {
}
