package skypro.teamproject.animalsheltertelegrambot.repository;

import skypro.teamproject.animalsheltertelegrambot.model.PersonDog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface PersonDogRepository.
 */
@Repository
public interface PersonDogRepository extends JpaRepository<PersonDog, Long> {

    Optional<PersonDog> findByChatId(Long chatId);

}
