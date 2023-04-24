package com.example.AppHR;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.example.AppHR.domain.dto.CandidateDTO;
import com.example.AppHR.domain.model.Candidate;
import com.example.AppHR.service.implemention.CandidateServiceImpl;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.AppHR.repository.CandidateRepository;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class CandidateServiceImplTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateServiceImpl candidateService;

    @Test
    public void testAddJobCandidate() throws ResourceNotFoundException {
        // Arrange
        CandidateDTO candidateDto = new CandidateDTO();
        candidateDto.setId(1L);
        candidateDto.setFirstname("Jane");
        candidateDto.setSurname("Doe");
        candidateDto.setBirthday(new Date(99,12,20));
        candidateDto.setPhone("+1234567890");
        candidateDto.setEmail("jane.doe99@example.com");

        Candidate candidate = new Candidate();
        candidate.setId(candidateDto.getId());
        candidate.setFirstname(candidateDto.getFirstname());
        candidate.setSurname(candidateDto.getSurname());
        candidate.setBirthday(candidateDto.getBirthday());
        candidate.setPhone(candidateDto.getPhone());
        candidate.setEmail(candidateDto.getEmail());


        when(candidateRepository.save(any(Candidate.class))).thenReturn(candidate);

        // Act
        Candidate result = candidateService.addJobCandidate(candidateDto);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(candidate.getId(), result.getId());
        Assertions.assertEquals(candidate.getFirstname(), result.getFirstname());
        Assertions.assertEquals(candidate.getSurname(), result.getSurname());
        Assertions.assertEquals(candidate.getBirthday(), result.getBirthday());
        Assertions.assertEquals(candidate.getPhone(), result.getPhone());
        Assertions.assertEquals(candidate.getEmail(), result.getEmail());


        verify(candidateRepository, times(1)).save(any(Candidate.class));
    }

}

