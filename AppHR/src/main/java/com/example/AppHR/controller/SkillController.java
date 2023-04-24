package com.example.AppHR.controller;

import com.example.AppHR.domain.dto.SkillDTO;
import com.example.AppHR.domain.dto.converters.SkillConverter;
import com.example.AppHR.domain.model.Skill;
import com.example.AppHR.service.definition.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Skill s = skillService.get(id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @GetMapping(path = "/skills")
    public ResponseEntity<?> getAllNotDeleted() {
        List<Skill> skills = skillService.getAllNotDeleted();

        return new ResponseEntity<>(SkillConverter.modelsToDTOs(skills), HttpStatus.OK);
    }





    @PostMapping(path = "/addSkill")
    public ResponseEntity<?> addSkills(@RequestBody SkillDTO dto) {
        Skill s = skillService.addSkills(dto);

        return new ResponseEntity<>(s, HttpStatus.OK);
    }



    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean delete = skillService.removeSkillFromJobCandidate(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/searchSkills")
    public ResponseEntity<?> searchSkills(@RequestBody SkillDTO dto){
        List<Skill> skills = skillService.searchAllCandidateWithGivenSkills(dto);
        return new ResponseEntity<>(SkillConverter.modelsToDTOs(skills),HttpStatus.OK);
    }

}
