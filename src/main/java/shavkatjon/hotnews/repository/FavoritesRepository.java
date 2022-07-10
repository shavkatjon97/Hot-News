package shavkatjon.hotnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shavkatjon.hotnews.entity.FavoriteEntity;

import java.util.UUID;

@Repository
public interface FavoritesRepository extends JpaRepository<FavoriteEntity, UUID> {

}
