package com.marcos.resume.controller;

import com.marcos.resume.dto.request.PersonRequestDTO;
import com.marcos.resume.dto.response.PersonResponseDTO;
import com.marcos.resume.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/person")
@RequiredArgsConstructor
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> findById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok().body(personService.getPersonById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDTO>> findAll() {
        return ResponseEntity.ok().body(personService.getAllPersons());
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> create(@RequestBody PersonRequestDTO personRequestDTO, UriComponentsBuilder uriBuilder) {
        PersonResponseDTO personResponseDTO = personService.register(personRequestDTO);
        URI uri = uriBuilder.path("/person'/{id}").buildAndExpand(personResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(personResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> update(@RequestBody PersonRequestDTO personDTO, @PathVariable(name = "id") Long id) {
    return  ResponseEntity.ok().body(personService.update(id, personDTO));
    }

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        return  ResponseEntity.ok().body(personService.delete(id));
    }

}
