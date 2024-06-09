package com.marcos.resume.service;

import com.marcos.resume.entity.ProfessionalExperience;
import com.marcos.resume.entity.Resume;
import com.marcos.resume.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    public List<Resume> findAll() {
        return resumeRepository.findAll();
    }

    public Optional<Resume> findById(Long id) {
        return resumeRepository.findById(id);
    }

    public Resume save(Resume resume) {
        return resumeRepository.save(resume);
    }

    public void deleteById(Long id) {
        resumeRepository.deleteById(id);
    }

}
