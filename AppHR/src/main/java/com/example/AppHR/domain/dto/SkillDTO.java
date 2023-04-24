package com.example.AppHR.domain.dto;

public class SkillDTO {
    private Long id;
    private String name;
    private boolean deleted;
    private String searchTerm;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getName(){return name; }
    public void setName(String name){this.name = name; }
    public boolean getDeleted(){return deleted; }
    public void setDeleted(boolean deleted){this.deleted = deleted; }
    public String getSearchTerm(){return searchTerm;}
    public void setSearchTerm(String searchTerm){this.searchTerm = searchTerm;}
}
