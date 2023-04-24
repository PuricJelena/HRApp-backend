package com.example.AppHR.domain.dto;

import java.util.Date;

public class CandidateDTO {
    private Long id;
    private String firstname;
    private String surname;
    private Date birthday;
    private String phone;
    private String email;
    private boolean deleted;
    private String searchTerm;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getFirstname(){return firstname; }
    public void setFirstname(String firstname){this.firstname = firstname; }
    public String getSurname(){return surname; }
    public void setSurname(String surname){this.surname = surname; }
    public Date getBirthday(){return birthday; }
    public void setBirthday(Date birthday){this.birthday = birthday; }
    public String getPhone(){return phone; }
    public void setPhone(String phone){this.phone = phone; }
    public String getEmail(){return email; }
    public void setEmail(String email){this.email = email; }
    public boolean getDeleted(){return deleted; }
    public void setDeleted(boolean deleted){this.deleted = deleted; }
    public String getSearchTerm(){return searchTerm;}
    public void setSearchTerm(String searchTerm){this.searchTerm = searchTerm;}
}
