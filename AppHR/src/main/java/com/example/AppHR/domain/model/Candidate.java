package com.example.AppHR.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="candidates")
public class Candidate {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String firstname;
    private String surname;
    private Date birthday;
    private String phone;
    private String email;
    private boolean deleted;

}
