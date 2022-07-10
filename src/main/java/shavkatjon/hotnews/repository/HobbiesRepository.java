package shavkatjon.hotnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shavkatjon.hotnews.entity.Hobby;

import java.util.UUID;

@Repository
public interface HobbiesRepository extends JpaRepository<Hobby, UUID> {
}
