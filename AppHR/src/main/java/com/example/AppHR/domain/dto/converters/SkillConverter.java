package com.example.AppHR.domain.dto.converters;

import com.example.AppHR.domain.dto.CandidateDTO;
import com.example.AppHR.domain.dto.SkillDTO;
import com.example.AppHR.domain.model.Candidate;
import com.example.AppHR.domain.model.Skill;

import java.util.ArrayList;
import java.util.List;

public class SkillConverter {
    public static SkillDTO modelToDTO(Skill skill) {
        SkillDTO dto = new SkillDTO();
        dto.setId(skill.getId());
        dto.setName(skill.getName());

        return dto;
    }

    public static List<SkillDTO> modelsToDTOs(List<Skill> skills) {
        List<SkillDTO> result = new ArrayList<>();

        for(Skill s: skills){
            result.add(modelToDTO(s));
        }
        return result;
    }
}
