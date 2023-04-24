package com.example.AppHR.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="job_candidates")
public class JobCandidate {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private boolean deleted;

    @ManyToOne
    private Candidate candidate;
    @ManyToOne
    private Skill skill;

}
