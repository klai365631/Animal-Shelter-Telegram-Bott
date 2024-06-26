package skypro.teamproject.animalsheltertelegrambot.service;

import skypro.teamproject.animalsheltertelegrambot.exceptions.PersonDogNotFoundException;
import skypro.teamproject.animalsheltertelegrambot.repository.PersonDogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Class of PersonDogService.
 */
@Service
public class PersonDogService {

    private final PersonDogRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(PersonDogService.class);

    public PersonDogService(PersonDogRepository repository) {
        this.repository = repository;
    }

    /**
     * Method to get a personDog by id.
     * @param id
     * @return {@link PersonDogRepository#findById(Object)}
     * @see PersonDogService
     * @exception PersonDogNotFoundException
     */
    public PersonDog getById(Long id) {
        logger.info("Was invoked method to get a personDog by id={}", id);

        return this.repository.findById(id)
                .orElseThrow(PersonDogNotFoundException::new);
    }

    /**
     * Method to create a personDog.
     * @param personDog
     * @return {@link PersonDogRepository#save(Object)}
     * @see PersonDogService
     */
    public PersonDog create(PersonDog personDog) {
        logger.info("Was invoked method to create a personDog");

        return this.repository.save(personDog);
    }

    /**
     * Method to update a personDog.
     * @param personDog
     * @return {@link PersonDogRepository#save(Object)}
     * @see PersonDogService
     * @exception PersonDogNotFoundException
     */
    public PersonDog update(PersonDog personDog) {
        logger.info("Was invoked method to update a personDog");

        if (personDog.getId() != null) {
            if (getById(personDog.getId()) != null) {
                return this.repository.save(personDog);
            }
        }
        throw new PersonDogNotFoundException();
    }

    /**
     * Method to remove a personDog by id.
     * @param id
     */
    public void removeById(Long id) {
        logger.info("Was invoked method to remove a personDog by id={}", id);

        this.repository.deleteById(id);
    }

    /**
     * Method to get all personsDod.
     * @return {@link PersonDogRepository#findAll()}
     * @see PersonDogService
     */
    public Collection<PersonDog> getAll() {
        logger.info("Was invoked method to get all personsDod");

        return this.repository.findAll();
    }

    /**
     * Method to get a personsDog by chatId.
     * @param chatId
     * @return {@link PersonDogRepository#findByChatId(Long)}
     * @see PersonDogService
     */
    public Optional<PersonDog> getByChatId(Long chatId) {
        logger.info("Was invoked method to get a personsDog by chatId={}", chatId);

        return this.repository.findByChatId(chatId);
    }
}
