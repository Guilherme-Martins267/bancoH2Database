package Martins.Guilherme.bancoH2Database.controller;
import Martins.Guilherme.bancoH2Database.model.PersonagensEntity;
import Martins.Guilherme.bancoH2Database.repository.PersonagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagensController {

    @Autowired
    private PersonagensRepository personagensRepository;

    @GetMapping
    public ResponseEntity<List<PersonagensEntity>> findAll() {
        return new ResponseEntity<List<PersonagensEntity>>(
                (List<PersonagensEntity>) this.personagensRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonagensEntity> findById(@PathVariable("id") long id) {
        if (this.personagensRepository.findById(id).isPresent()) {
            return new ResponseEntity<PersonagensEntity>(
                    this.personagensRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<PersonagensEntity>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PersonagensEntity> store(@RequestBody PersonagensEntity personagensEntity) {
        return new ResponseEntity<PersonagensEntity>(
                this.personagensRepository.save(personagensEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonagensEntity> update(@PathVariable("id") long id,
                                                    @RequestBody PersonagensEntity personagensEntity) throws Exception {

        if (id == 0 || !this.personagensRepository.existsById(id)) {
            throw new Exception("Código não encontrado ou inexistente");
        }
        return new ResponseEntity<PersonagensEntity>(
                this.personagensRepository.save(personagensEntity),
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PersonagensEntity> delete(@PathVariable("id") long id) {
        this.personagensRepository.deleteById(id);
        return new ResponseEntity<PersonagensEntity>(new HttpHeaders(), HttpStatus.OK);
    }
}