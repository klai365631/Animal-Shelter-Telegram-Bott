package skypro.teamproject.animalsheltertelegrambot.repository;

import skypro.teamproject.animalsheltertelegrambot.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface CatRepository.
 */

@Repository
public interface CatRepository extends JpaRepository <Cat, Long> {
}
