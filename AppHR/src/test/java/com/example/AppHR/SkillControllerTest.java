package com.example.AppHR;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.example.AppHR.controller.SkillController;
import com.example.AppHR.domain.dto.SkillDTO;
import com.example.AppHR.domain.model.Skill;
import com.example.AppHR.service.definition.SkillService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class SkillControllerTest {

    @Mock
    private SkillService skillService;

    @InjectMocks
    private SkillController skillController;

    private SkillDTO skillDTO;

    @Before
    public void setup() {
        skillDTO = new SkillDTO();
        skillDTO.setId(1L);
        skillDTO.setName("Java");
        skillDTO.setDeleted(false);

    }

    @Test
    public void testAddSkills() {
        Skill skill = new Skill();
        skill.setId(1L);
        skill.setName("Java");

        when(skillService.addSkills(skillDTO)).thenReturn(skill);

        ResponseEntity<?> response = skillController.addSkills(skillDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(skill, response.getBody());
    }
}

