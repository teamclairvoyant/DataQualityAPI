package com.cv.dataqualityapi.Repo;

import com.cv.dataqualityapi.model.Rules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface RulesRepo extends JpaRepository<Rules,Integer> {

//    @Query(
//            value = "SELECT r*, rs*, rp*, rem*, rt*, rtp*, e*, ep*, et*, etp* from " +
//                    "rules r, ruleset rs ,rule_properties rp," +
//                    "rule_entity_map rem,rule_template rt, rule_template_properties rtp,entity e" +
//                    "entity_properties ep,entity_template et, entity_template_properties etp"
//                    + "where r.rule_id = rp.rule_id"
//                    + "where r.rule_id = rem.rule_id"
//                    + "where r.rule_set_id = rs.rule_set_id "
//                    + "where r.rule_template_id = rt.rule_template_id"
//                    + "where rt.rule_template_id = rtp.rule_template_id"
//                    + "where rem.entity_id = e.entity_id"
//                    + "where ep.entity_id = e.entity_id"
//                    + "where e.entity_template_id = et.entity_template_id"
//                    + "where et.entity_template_id = etp.entity_template_id"
//                    + "and r.rule_id=?1 ",
//            nativeQuery = true
//    )
//    List<Map<String, Object>>  findRuleById(Long ruleId);

        Optional<Rules> findByRuleName(String ruleName);
}

