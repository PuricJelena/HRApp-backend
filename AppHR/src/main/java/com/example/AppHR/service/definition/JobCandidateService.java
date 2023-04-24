package com.example.AppHR.service.definition;

import com.example.AppHR.domain.dto.JobCandidateDTO;
import com.example.AppHR.domain.model.JobCandidate;


import java.util.List;

public interface JobCandidateService {
    JobCandidate get(Long id);
    List<JobCandidate> getAllNotDeleted();
    List<JobCandidate> findAllActiveJobCandidates();
    List<JobCandidate> getAllCandidateSkills(Long candidateId);
    JobCandidate updateJobCandidateSkill(Long id, JobCandidateDTO dto);
    boolean removeSkillFromCandidate(Long id);
    JobCandidate updateCandidateWithSkills(JobCandidateDTO dto);
    List<JobCandidate> searchAllCandidateWithSkills(JobCandidateDTO dto);
    boolean jobCandidateExists(JobCandidate jobCandidate, List<JobCandidate> jobCandidates);
}
