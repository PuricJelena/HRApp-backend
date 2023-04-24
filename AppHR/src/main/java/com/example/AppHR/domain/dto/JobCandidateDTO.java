package com.example.AppHR.domain.dto;

import java.util.Date;

public class JobCandidateDTO {
    private Long id;
    private boolean deleted;
    private Long candidateId;
    private Long skillId;
    private String searchTerm;
    private String firstname;
    private String surname;
    private String name;
    private String email;
    private String phone;
    private Date birthday;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public boolean getDeleted(){return deleted; }
    public void setDeleted(boolean deleted){this.deleted = deleted; }
    public Long getCandidateId(){ return candidateId; }
    public void setCandidateId(Long candidateId){ this.candidateId = candidateId; }
    public Long getSkillId(){ return skillId; }
    public void setSkillId(Long skillId){ this.skillId = skillId; }
    public String getSearchTerm(){return searchTerm;}
    public void setSearchTerm(String searchTerm){this.searchTerm = searchTerm;}
    public String getFirstname(){return firstname; }
    public void setFirstname(String firstname){this.firstname = firstname; }
    public String getName(){return name; }
    public void setName(String name){this.name = name; }
    public String getSurname(){return surname; }
    public void setSurname(String surname){this.surname = surname; }
    public Date getBirthday(){return birthday; }
    public void setBirthday(Date birthday){this.birthday = birthday; }
    public String getPhone(){return phone; }
    public void setPhone(String phone){this.phone = phone; }
    public String getEmail(){return email; }
    public void setEmail(String email){this.email = email; }
}
