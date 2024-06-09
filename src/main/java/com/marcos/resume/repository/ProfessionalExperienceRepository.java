package com.marcos.resume.repository;

import com.marcos.resume.entity.Person;
import com.marcos.resume.entity.ProfessionalExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalExperienceRepository extends JpaRepository<ProfessionalExperience, Long> {

}
