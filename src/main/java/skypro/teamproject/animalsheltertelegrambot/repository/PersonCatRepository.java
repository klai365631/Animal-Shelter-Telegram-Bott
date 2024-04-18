package skypro.teamproject.animalsheltertelegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interface PersonCatRepository.
 */
public interface PersonCatRepository extends JpaRepository<PersonCat, Long> {

    Optional<PersonCat> findByChatId(Long chatId);

}