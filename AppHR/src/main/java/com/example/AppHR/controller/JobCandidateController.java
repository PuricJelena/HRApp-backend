package com.example.AppHR.controller;

import com.example.AppHR.domain.dto.CandidateDTO;
import com.example.AppHR.domain.dto.JobCandidateDTO;
import com.example.AppHR.domain.dto.converters.JobCandidateConverter;
import com.example.AppHR.domain.model.Candidate;
import com.example.AppHR.domain.model.JobCandidate;
import com.example.AppHR.service.definition.JobCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/jobCandidate")
public class JobCandidateController {

    @Autowired
    private JobCandidateService jobCandidateService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        JobCandidate jc = jobCandidateService.get(id);
        return new ResponseEntity<>(jc, HttpStatus.OK);
    }

    @GetMapping(path = "/skills")
    public ResponseEntity<?> getAllNotDeleted() {
        List<JobCandidate> jobCandidates = jobCandidateService.getAllNotDeleted();

        return new ResponseEntity<>(JobCandidateConverter.modelsToDTOs(jobCandidates), HttpStatus.OK);
    }

    @GetMapping(path = "/activeCandidates")
    public ResponseEntity<?> findAllActiveJobCandidates() {
        List<JobCandidate> jobCandidates = jobCandidateService.findAllActiveJobCandidates();

        return new ResponseEntity<>(JobCandidateConverter.modelsToDTOs(jobCandidates), HttpStatus.OK);
    }

    @GetMapping(path = "/candidateSkills/{id}")
    public ResponseEntity<?> getCandidateSkills(@PathVariable Long id) {
        return new ResponseEntity<>(jobCandidateService.getAllCandidateSkills(id), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateJobCandidateSkill(@PathVariable Long id, @RequestBody JobCandidateDTO dto) {
        JobCandidate jc = jobCandidateService.updateJobCandidateSkill(id,dto);
        return new ResponseEntity<>(jc,HttpStatus.OK);
    }


    @PostMapping(path = "/addCandidateSkill")
    public ResponseEntity<?> updateCandidateSkills(@RequestBody JobCandidateDTO dto) {
        JobCandidate jc = jobCandidateService.updateCandidateWithSkills(dto);

        return new ResponseEntity<>(jc, HttpStatus.OK);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean delete = jobCandidateService.removeSkillFromCandidate(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/searchJobSkills")
    public ResponseEntity<?> searchSkills(@RequestBody JobCandidateDTO dto){
        List<JobCandidate> jobCandidates = jobCandidateService.searchAllCandidateWithSkills(dto);
        return new ResponseEntity<>(JobCandidateConverter.modelsToDTOs(jobCandidates),HttpStatus.OK);
    }

}
