package com.example.AppHR.service.implemention;

import com.example.AppHR.domain.dto.CandidateDTO;
import com.example.AppHR.domain.model.Candidate;
import com.example.AppHR.repository.CandidateRepository;
import com.example.AppHR.service.definition.CandidateService;
import com.example.AppHR.service.definition.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository  candidateRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }


    @Override
    public List<Candidate> getAllNotDeleted() {
        return candidateRepository.findAllByDeleted(false);
    }

    @Override
    public Candidate get(Long id) {
        return candidateRepository.findById(id).get();
    }

    @Override
    public Candidate getLatestCandidate() {
        return candidateRepository.findTopByOrderByIdDesc();
    }

    @Override
    public Candidate getFirstCandidate() {
        return candidateRepository.findTopByOrderByIdAsc();
    }


    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Candidate addJobCandidate(CandidateDTO dto) {

        Candidate c = new Candidate();
        c.setId(dto.getId());
        c.setFirstname(dto.getFirstname());
        c.setSurname(dto.getSurname());
        c.setBirthday(dto.getBirthday());
        c.setPhone(dto.getPhone());
        c.setEmail(dto.getEmail());
        c.setDeleted(false);

        return candidateRepository.save(c);
    }

    @Override
    public Candidate updateJobCandidate(Long id, CandidateDTO dto) {

        Optional<Candidate> optionalCandidate = candidateRepository.findById(id);

        optionalCandidate.get().setFirstname(dto.getFirstname());
        optionalCandidate.get().setSurname(dto.getSurname());
        optionalCandidate.get().setBirthday(dto.getBirthday());
        optionalCandidate.get().setPhone(dto.getPhone());
        optionalCandidate.get().setEmail(dto.getEmail());

        return candidateRepository.save(optionalCandidate.get());
    }



    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public boolean removeCandidate(Long id) {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(id);
        optionalCandidate.get().setDeleted(true);
        candidateRepository.save(optionalCandidate.get());
        return true;
    }

    @Override
    public List<Candidate> searchCandidateByName(CandidateDTO dto) {

        List<Candidate> results = new ArrayList<>();
        List<Candidate> candidates = candidateRepository.findAllByDeleted(false);

        for(Candidate c: candidates){
            if(c.getFirstname().toLowerCase().contains(dto.getSearchTerm().toLowerCase()) || c.getSurname().toLowerCase().contains(dto.getSearchTerm().toLowerCase()))
            {

                if (!candidateExists(c, results)) {
                    results.add(c);
                }
            }
        }
        return results;
    }

    @Override
    public boolean candidateExists(Candidate candidate, List<Candidate> candidates) {
        for(Candidate c: candidates){
            if(c.getId().equals(candidate.getId()))
                return true;
        }
        return false;
    }
}
