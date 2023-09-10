package com.cv.dataqualityapi.Repo;

import com.cv.dataqualityapi.model.RuleTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleTemplateRepo extends JpaRepository<RuleTemplate,Integer> {
}
