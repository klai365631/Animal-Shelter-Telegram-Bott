package skypro.teamproject.animalsheltertelegrambot.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import skypro.teamproject.animalsheltertelegrambot.model.PersonCat;
import skypro.teamproject.animalsheltertelegrambot.service.PersonCatService;

import java.util.Collection;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
/**
 * Class of PersonCatController.
 */
@RestController
@RequestMapping("person-cat")
public class PersonCatController {

    private final PersonCatService service;

    public PersonCatController(PersonCatService service) {
        this.service = service;
    }

    @Operation(summary = "Получение пользователя по id")
    @GetMapping("/{id}")
    public PersonCat getById(@PathVariable Long id) {
        return this.service.getById(id);
    }

    @Operation(summary = "Создание пользователя")
    @PostMapping()
    public PersonCat save(@RequestBody PersonCat personCat) {
        return this.service.create(personCat);
    }

    @Operation(summary = "Изменение данных пользователя")
    @PutMapping
    public PersonCat update(@RequestBody PersonCat personCat) {
        return this.service.update(personCat);
    }

    @Operation(summary = "Удаление пользователей по id")
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        this.service.removeById(id);
    }

    @Operation(summary = "Просмотр всех пользователей", description = "Просмотр всех пользователей, либо определенного пользователя по chat_id")
    @GetMapping("/all")
    public Collection<PersonCat> getAll(@RequestParam(required = false) Long chatId) {
        if (chatId != null) {
            Optional<PersonCat> catPerson =  this.service.getByChatId(chatId);
            if (catPerson.isPresent()) {
                return singletonList(catPerson.get());
            } return emptyList();
        }
        return this.service.getAll();
    }
}
