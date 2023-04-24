package com.example.AppHR.repository;

import com.example.AppHR.domain.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findAllByDeleted(boolean deleted);
    List<Skill> findAllById(Long id);
    List<Skill> findAllByName(String name);
}
