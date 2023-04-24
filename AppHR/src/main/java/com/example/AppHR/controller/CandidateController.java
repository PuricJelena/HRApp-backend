package com.example.AppHR.controller;

import com.example.AppHR.domain.dto.CandidateDTO;
import com.example.AppHR.domain.dto.converters.CandidateConverter;
import com.example.AppHR.domain.model.Candidate;
import com.example.AppHR.service.definition.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Candidate c = candidateService.get(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping(path = "/candidates")
    public ResponseEntity<?> getAllNotDeleted() {
        List<Candidate> candidates = candidateService.getAllNotDeleted();

        return new ResponseEntity<>(CandidateConverter.modelsToDTOs(candidates), HttpStatus.OK);
    }

    @GetMapping(path = "/latestCandidate")
    public ResponseEntity<?> getLatestCandidate() {
        return new ResponseEntity<>(candidateService.getLatestCandidate(), HttpStatus.OK);
    }

    @GetMapping(path = "/firstCandidate")
    public ResponseEntity<?> getFirstCandidate() {
        return new ResponseEntity<>(candidateService.getFirstCandidate(), HttpStatus.OK);
    }

    @PostMapping(path = "/addCandidate")
    public ResponseEntity<?> addJobCandidate(@RequestBody CandidateDTO dto) {
        Candidate c = candidateService.addJobCandidate(dto);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateJobCandidate(@PathVariable Long id, @RequestBody CandidateDTO dto) {
        Candidate c = candidateService.updateJobCandidate(id,dto);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean delete = candidateService.removeCandidate(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/searchCandidates")
    public ResponseEntity<?> searchCandidates(@RequestBody CandidateDTO dto){
        List<Candidate> candidates = candidateService.searchCandidateByName(dto);
        return new ResponseEntity<>(CandidateConverter.modelsToDTOs(candidates),HttpStatus.OK);
    }

}
