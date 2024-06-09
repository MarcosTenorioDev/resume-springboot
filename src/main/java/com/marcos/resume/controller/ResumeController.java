package com.marcos.resume.controller;

import com.marcos.resume.entity.Resume;
import com.marcos.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public List<Resume> getAllResumes() {
        return resumeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable Long id) {
        Optional<Resume> resume = resumeService.findById(id);
        return resume.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Resume createResume(@RequestBody Resume resume) {
        return resumeService.save(resume);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resume> updateResume(@PathVariable Long id, @RequestBody Resume resumeDetails) {
        Optional<Resume> resumeOptional = resumeService.findById(id);
        if (resumeOptional.isPresent()) {
            Resume resume = resumeOptional.get();
            resume.setObjective(resumeDetails.getObjective());
            resume.setPerson(resumeDetails.getPerson());
            resume.setExperiences(resumeDetails.getExperiences());
            Resume updatedResume = resumeService.save(resume);
            return ResponseEntity.ok(updatedResume);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResume(@PathVariable Long id) {
        Optional<Resume> resumeOptional = resumeService.findById(id);
        if (resumeOptional.isPresent()) {
            resumeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
