package com.marcos.resume.dto.response;

import com.marcos.resume.entity.Person;
import lombok.Getter;


@Getter
public class PersonResponseDTO {

    private Long id;


    private String cpf;


    private String name;


    private Integer age;

    public PersonResponseDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
        this.cpf = person.getCpf();
    }

}
