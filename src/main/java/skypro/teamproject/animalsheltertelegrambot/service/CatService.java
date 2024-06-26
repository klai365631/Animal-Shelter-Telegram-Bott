package skypro.teamproject.animalsheltertelegrambot.service;

import skypro.teamproject.animalsheltertelegrambot.exceptions.CatNotFoundException;
import skypro.teamproject.animalsheltertelegrambot.repository.CatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Class of CatService
 */
@Service
public class CatService {

    private final CatRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(CatService.class);


    public CatService(CatRepository repository) {
        this.repository = repository;
    }

    /**
     * Method to get a cat by id.
     *
     * @param id
     * @return {@link CatRepository#findById(Object)}
     * @throws CatNotFoundException
     * @see CatService
     */
    public Cat getById(Long id) {
        logger.info("Was invoked method to get a cat by id={}", id);
        return this.repository.findById(id)
                .orElseThrow(CatNotFoundException::new);
    }

    /**
     * Method to create a cat.
     *
     * @param cat
     * @return {@link CatRepository#save(Object)}
     * @see CatService
     */

    public Cat create(Cat cat) {
        logger.info("Was invoked method to create a cat");
        return this.repository.save(cat);
    }

    /**
     * Method to update a cat.
     *
     * @param cat
     * @return {@link CatRepository#save(Object)}
     * @throws CatNotFoundException
     * @see CatService
     */

    public Cat update(Cat cat) {
        logger.info("Was invoked method to update a cat");
        if (cat.getId() != null) {
            if (getById(cat.getId()) != null) {
                return this.repository.save(cat);
            }
        }
        throw new CatNotFoundException();
    }

    /**
     * Method to get all cats.
     *
     * @return {@link CatRepository#findAll()}
     * @see CatService
     */

    public Collection<Cat> getAll() {
        logger.info("Was invoked method to get all cats");
        return this.repository.findAll();
    }

    /**
     * Method to remove a cat by id.
     *
     * @param id
     */

    public void removeById(Long id) {
        logger.info("Was invoked method to remove a cat by id={}", id);
        this.repository.deleteById(id);
    }
}
