package com.marcos.resume.repository;

import com.marcos.resume.entity.Person;
import com.marcos.resume.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
