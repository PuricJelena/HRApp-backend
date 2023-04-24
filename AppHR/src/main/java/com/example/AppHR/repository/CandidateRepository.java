package com.example.AppHR.repository;

import com.example.AppHR.domain.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findAllByDeleted(boolean deleted);
    List<Candidate> findAllById(Long id);
    Candidate findTopByOrderByIdDesc();
    Candidate findTopByOrderByIdAsc();
}
