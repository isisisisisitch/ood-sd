package ca.bytetube.ood._12_criteriabasedfilter;

import java.util.List;
import java.util.Map;

public class LogicalCriteria extends Criteria {
    List<Criteria> criteriaList;

    public LogicalCriteria(String operator, List<Criteria> criteriaList) {
        super(operator);
        this.criteriaList = criteriaList;
    }

    @Override
    public boolean isMatch(Map<String, Object> input) {
        if (input == null) return false;
        switch (operator.toLowerCase()) {
            case "and":
                return criteriaList.stream().allMatch(criteria -> criteria.isMatch(input));
            case "or":
                return criteriaList.stream().anyMatch(criteria -> criteria.isMatch(input));
            case "not":
                return criteriaList.stream().noneMatch(criteria -> criteria.isMatch(input));
        }
        return false;
    }
}
