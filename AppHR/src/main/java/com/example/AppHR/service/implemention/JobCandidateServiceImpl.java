package com.example.AppHR.service.implemention;

import com.example.AppHR.domain.dto.CandidateDTO;
import com.example.AppHR.domain.dto.JobCandidateDTO;
import com.example.AppHR.domain.dto.SkillDTO;
import com.example.AppHR.domain.model.Candidate;
import com.example.AppHR.domain.model.JobCandidate;
import com.example.AppHR.domain.model.Skill;
import com.example.AppHR.repository.CandidateRepository;
import com.example.AppHR.repository.JobCandidateRepository;
import com.example.AppHR.repository.SkillRepository;
import com.example.AppHR.service.definition.JobCandidateService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobCandidateServiceImpl implements JobCandidateService {

    @Autowired
    private JobCandidateRepository jobCandidateRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<JobCandidate> getAllNotDeleted() {
        return jobCandidateRepository.findAllByDeleted(false);
    }

    @Override
    public JobCandidate get(Long id) {
        return jobCandidateRepository.findById(id).get();
    }

    @Override
    public List<JobCandidate> findAllActiveJobCandidates() {
        return jobCandidateRepository.findByCandidateDeletedFalseAndDeletedFalse();
    }

    @Override
    public List<JobCandidate> getAllCandidateSkills(Long candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new EntityNotFoundException("Candidate not found"));
        return jobCandidateRepository.findAllByCandidateAndDeleted(candidate, false);}

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public JobCandidate updateCandidateWithSkills(JobCandidateDTO dto) {

        Candidate candidate = candidateRepository.findById(dto.getCandidateId()).get();
        Skill skill = skillRepository.findById(dto.getSkillId()).get();

        JobCandidate jc = new JobCandidate();
        jc.setId(dto.getId());
        jc.setDeleted(false);
        jc.setCandidate(candidate);
        jc.setSkill(skill);

        return jobCandidateRepository.save(jc);
    }

    @Override
    public JobCandidate updateJobCandidateSkill(Long id, JobCandidateDTO dto) {

        Optional<JobCandidate> optionalJobCandidate = jobCandidateRepository.findById(id);
        Skill skill = skillRepository.findById(dto.getSkillId()).orElse(null);

        if (optionalJobCandidate.isPresent()  && skill != null) {
            optionalJobCandidate.get().setSkill(skill);

            return jobCandidateRepository.save(optionalJobCandidate.get());
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public boolean removeSkillFromCandidate(Long id) {
        Optional<JobCandidate> optionalJobCandidate = jobCandidateRepository.findById(id);
        optionalJobCandidate.get().setDeleted(true);
        jobCandidateRepository.save(optionalJobCandidate.get());
        return true;
    }

    @Override
    public List<JobCandidate> searchAllCandidateWithSkills(JobCandidateDTO dto) {

        List<JobCandidate> results = new ArrayList<>();
        List<JobCandidate> jobCandidates = jobCandidateRepository.findAllByDeleted(false);

        for(JobCandidate jc: jobCandidates){
            if(jc.getSkill().getName().toLowerCase().contains(dto.getSearchTerm().toLowerCase()))
            {

                if (!jobCandidateExists(jc, results)) {
                    results.add(jc);
                }
            }
        }
        return results;
    }

    @Override
    public boolean jobCandidateExists(JobCandidate jobCandidate, List<JobCandidate> jobCandidates) {
        for(JobCandidate jc: jobCandidates){
            if(jc.getId().equals(jobCandidate.getId()))
                return true;
        }
        return false;
    }
}
