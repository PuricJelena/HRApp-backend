package com.example.AppHR.service.definition;

import com.example.AppHR.domain.dto.CandidateDTO;
import com.example.AppHR.domain.dto.SkillDTO;
import com.example.AppHR.domain.model.Candidate;
import com.example.AppHR.domain.model.Skill;

import java.util.List;

public interface SkillService {
    Skill get(Long id);
    List<Skill> getAllNotDeleted();
    boolean removeSkillFromJobCandidate(Long id);
    Skill addSkills(SkillDTO dto);
    List<Skill> searchAllCandidateWithGivenSkills(SkillDTO dto);
    boolean skillExists(Skill skill, List<Skill> skills);
}
