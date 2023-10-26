package com.cv.dataqualityapi.Repo;

import com.cv.dataqualityapi.model.RuleEntityMap;
import org.hibernate.boot.model.naming.EntityNaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RuleEntityMapRepo extends JpaRepository<RuleEntityMap,Integer> {

}
