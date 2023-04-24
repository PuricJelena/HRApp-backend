package com.example.AppHR.domain.dto.converters;

import com.example.AppHR.domain.dto.CandidateDTO;
import com.example.AppHR.domain.model.Candidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateConverter {
    public static CandidateDTO modelToDTO(Candidate candidate) {
        CandidateDTO dto = new CandidateDTO();
        dto.setId(candidate.getId());
        dto.setFirstname(candidate.getFirstname());
        dto.setSurname(candidate.getSurname());
        dto.setBirthday(candidate.getBirthday());
        dto.setPhone(candidate.getPhone());
        dto.setEmail(candidate.getEmail());

        return dto;
    }

    public static List<CandidateDTO> modelsToDTOs(List<Candidate> candidates) {
        List<CandidateDTO> result = new ArrayList<>();

        for(Candidate c: candidates){
            result.add(modelToDTO(c));
        }
        return result;
    }
}
