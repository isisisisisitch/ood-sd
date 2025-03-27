package ca.bytetube.ood._12_criteriabasedfilter;

import java.util.List;

public class CriteriaFactory {
    public static ComparisonCriteria createComparisonCriteria(String name, Object val, String operator) {
        return new ComparisonCriteria(name, val, operator);
    }

    public static LogicalCriteria createLogicalCriteria(String operator, List<Criteria> criteriaList) {
        return new LogicalCriteria(operator, criteriaList);
    }
}
