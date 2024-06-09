package com.marcos.resume.service;

import com.marcos.resume.entity.ProfessionalExperience;
import com.marcos.resume.repository.ProfessionalExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalExperienceService {

    @Autowired
    private ProfessionalExperienceRepository professionalExperienceRepository;

    public List<ProfessionalExperience> findAll() {
        return professionalExperienceRepository.findAll();
    }

    public Optional<ProfessionalExperience> findById(Long id) {
        return professionalExperienceRepository.findById(id);
    }

    public ProfessionalExperience save(ProfessionalExperience professionalExperience) {
        return professionalExperienceRepository.save(professionalExperience);
    }

    public void deleteById(Long id) {
        professionalExperienceRepository.deleteById(id);
    }
}
