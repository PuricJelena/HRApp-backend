package com.example.AppHR.service.implemention;

import com.example.AppHR.domain.dto.CandidateDTO;
import com.example.AppHR.domain.dto.SkillDTO;
import com.example.AppHR.domain.model.Candidate;
import com.example.AppHR.domain.model.Skill;
import com.example.AppHR.repository.CandidateRepository;
import com.example.AppHR.repository.SkillRepository;
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
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private CandidateRepository candidateRepository;


    @Override
    public List<Skill> getAllNotDeleted() {
        return skillRepository.findAllByDeleted(false);
    }

    @Override
    public Skill get(Long id) {
        return skillRepository.findById(id).get();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Skill addSkills(SkillDTO dto) {


        Skill s = new Skill();
        s.setId(dto.getId());
        s.setName(dto.getName());
        s.setDeleted(false);

        return skillRepository.save(s);
    }



    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public boolean removeSkillFromJobCandidate(Long id) {
        Optional<Skill> optionalSkill = skillRepository.findById(id);
        optionalSkill.get().setDeleted(true);
        skillRepository.save(optionalSkill.get());
        return true;
    }

    @Override
    public List<Skill> searchAllCandidateWithGivenSkills(SkillDTO dto) {

        List<Skill> results = new ArrayList<>();
        List<Skill> skills = skillRepository.findAllByDeleted(false);

        for(Skill s: skills){
            if(s.getName().toLowerCase().contains(dto.getSearchTerm().toLowerCase()))
            {

                if (!skillExists(s, results)) {
                    results.add(s);
                }
            }
        }
        return results;
    }

    @Override
    public boolean skillExists(Skill skill, List<Skill> skills) {
        for(Skill s: skills){
            if(s.getId().equals(skill.getId()))
                return true;
        }
        return false;
    }

}
