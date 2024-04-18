package skypro.teamproject.animalsheltertelegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interface DogRepository.
 */
@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

}
