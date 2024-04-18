package skypro.teamproject.animalsheltertelegrambot.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import skypro.teamproject.animalsheltertelegrambot.model.Dog;
import skypro.teamproject.animalsheltertelegrambot.service.DogService;

import java.util.Collection;
/**
 * Class of DogController
 */
@RestController
@RequestMapping("dog")
public class DogController {
    private final DogService service;

    public DogController(DogService service) {
        this.service = service;
    }

    @Operation(summary = "Получение собаки по id")
    @GetMapping("/{id}")
    public Dog getById(@PathVariable Long id) {
        return this.service.getById(id);
    }

    @Operation(summary = "Создание собаки")
    @PostMapping()
    public Dog save(@RequestBody Dog dog) {
        return this.service.create(dog);
    }

    @Operation(summary = "Изменение данных у собаки")
    @PutMapping()
    public Dog update(@RequestBody Dog dog) {
        return this.service.update(dog);
    }

    @Operation(summary = "Удаленеи собаки по id")
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        this.service.removeById(id);
    }

    @Operation(summary = "Просмотр всех собак")
    @GetMapping("/all")
    public Collection<Dog> getAll() {
        return this.service.getAll();
    }
}
