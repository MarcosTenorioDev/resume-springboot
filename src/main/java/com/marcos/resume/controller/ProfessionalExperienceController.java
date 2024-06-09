package com.marcos.resume.controller;

import com.marcos.resume.dto.ProfessionalExperienceDTO;
import com.marcos.resume.entity.ProfessionalExperience;
import com.marcos.resume.service.ProfessionalExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/experience")
public class ProfessionalExperienceController {

    @Autowired
    private ProfessionalExperienceService professionalExperienceService;

        @GetMapping
    public List<ProfessionalExperienceDTO> getAllProfessionalExperiences() {
        List<ProfessionalExperience> experiences = professionalExperienceService.findAll();
        return experiences.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<ProfessionalExperience> getProfessionalExperienceById(@PathVariable Long id) {
        return professionalExperienceService.findById(id);
    }

    @PostMapping
    public ProfessionalExperience addProfessionalExperience(@RequestBody ProfessionalExperience professionalExperience) {
        return professionalExperienceService.save(professionalExperience);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessionalExperience(@PathVariable Long id) {
        professionalExperienceService.deleteById(id);
    }

    private ProfessionalExperienceDTO convertToDTO(ProfessionalExperience experience) {
        ProfessionalExperienceDTO dto = new ProfessionalExperienceDTO();
        dto.setCompany(experience.getCompany());
        dto.setPosition(experience.getPosition());
        dto.setDescription(experience.getDescription());
        dto.setPerson(experience.getResume().getPerson());
        return dto;
    }
}
