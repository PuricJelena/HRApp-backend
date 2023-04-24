package com.example.AppHR.domain.dto.converters;

import com.example.AppHR.domain.dto.JobCandidateDTO;
import com.example.AppHR.domain.model.JobCandidate;

import java.util.ArrayList;
import java.util.List;

public class JobCandidateConverter {
    public static JobCandidateDTO modelToDTO(JobCandidate jc) {
        JobCandidateDTO dto = new JobCandidateDTO();
        dto.setId(jc.getId());
        dto.setCandidateId(jc.getCandidate().getId());
        dto.setSkillId(jc.getSkill().getId());
        dto.setFirstname(jc.getCandidate().getFirstname());
        dto.setSurname(jc.getCandidate().getSurname());
        dto.setBirthday(jc.getCandidate().getBirthday());
        dto.setPhone(jc.getCandidate().getPhone());
        dto.setEmail(jc.getCandidate().getEmail());
        dto.setName(jc.getSkill().getName());





        return dto;
    }

    public static List<JobCandidateDTO> modelsToDTOs(List<JobCandidate> jobCandidates) {
        List<JobCandidateDTO> result = new ArrayList<>();

        for(JobCandidate jc: jobCandidates){
            result.add(modelToDTO(jc));
        }
        return result;
    }
}