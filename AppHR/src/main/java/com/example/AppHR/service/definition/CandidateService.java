package com.example.AppHR.service.definition;

import com.example.AppHR.domain.dto.CandidateDTO;
import com.example.AppHR.domain.model.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CandidateService {
    Candidate get(Long id);
    List<Candidate> getAllNotDeleted();
    boolean removeCandidate(Long id);
    Candidate addJobCandidate(CandidateDTO dto);
    Candidate updateJobCandidate(Long id, CandidateDTO dto);
    Candidate getLatestCandidate();
    Candidate getFirstCandidate();
    List<Candidate> searchCandidateByName(CandidateDTO dto);
    boolean candidateExists(Candidate candidate, List<Candidate> candidates);
}
