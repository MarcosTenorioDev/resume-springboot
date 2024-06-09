package com.marcos.resume.service;

import com.marcos.resume.dto.response.PersonResponseDTO;
import com.marcos.resume.dto.request.PersonRequestDTO;
import java.util.List;


public interface PersonService {

    PersonResponseDTO getPersonById(Long id);

    List<PersonResponseDTO> getAllPersons();

    PersonResponseDTO register(PersonRequestDTO personDTO);

    PersonResponseDTO update( Long id, PersonRequestDTO personDTO);

    String delete (Long id);
}
