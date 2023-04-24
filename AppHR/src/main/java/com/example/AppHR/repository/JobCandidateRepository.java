package com.example.AppHR.repository;

import com.example.AppHR.domain.model.Candidate;
import com.example.AppHR.domain.model.JobCandidate;
import com.example.AppHR.domain.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobCandidateRepository extends JpaRepository<JobCandidate, Long> {
    List<JobCandidate> findAllByDeleted(boolean deleted);
    List<JobCandidate> findAllByCandidateId(Long candidateId);
    List<JobCandidate> findAllBySkillId(Long skillId);
    List<JobCandidate> findByCandidateDeletedFalseAndDeletedFalse();
    List<JobCandidate> findAllByCandidateAndDeleted(Candidate candidate, boolean deleted);


}
