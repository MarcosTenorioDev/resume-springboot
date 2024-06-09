package com.marcos.resume.service;
import com.marcos.resume.dto.request.PersonRequestDTO;
import com.marcos.resume.dto.response.PersonResponseDTO;
import com.marcos.resume.entity.Person;
import com.marcos.resume.repository.PersonRepository;
import com.marcos.resume.utils.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImplements implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;


    @Override
    public PersonResponseDTO getPersonById(Long id) {
        return personMapper.toPersonDTO(returnPerson(id));
    }

    @Override
    public List<PersonResponseDTO> getAllPersons() {
        return personMapper.toPeopleDTO(personRepository.findAll());
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
       Person person = personMapper.toPerson(personDTO);
       return personMapper.toPersonDTO( personRepository.save(person));
    }

    @Override
    public PersonResponseDTO update( Long id, PersonRequestDTO personDTO) {
        Person person = returnPerson(id);
        personMapper.updatePersonData(person, personDTO);
        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public String delete(Long id) {
       personRepository.deleteById(id);
       return "Person id: "+id+" deletado com sucesso!";
    }

    private Person returnPerson(Long id) {
        return  personRepository.findById(id).orElseThrow(() -> new RuntimeException(("Person not found")));
    }

}
