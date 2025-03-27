package ca.bytetube.ood._12_criteriabasedfilter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ComparisonCriteria ageCriteria = CriteriaFactory.createComparisonCriteria("age", 30, ">");
        ComparisonCriteria nameCriteria = CriteriaFactory.createComparisonCriteria("name", "Dal", "==");

        List<Criteria> criteriaList = Arrays.asList(ageCriteria, nameCriteria);
//        LogicalCriteria andCriteria = CriteriaFactory.createLogicalCriteria("and", criteriaList);
//
//        Map<String, Object> input1 = new HashMap<>();
//        input1.put("age", 35);
//        input1.put("name", "Dal");
//        System.out.println(CriteriaEvaluator.isMatch(andCriteria, input1));

//        Map<String, Object> input2 = new HashMap<>();
//        input2.put("age", 25);
//        input2.put("name", "Dal");
//        LogicalCriteria orCriteria = CriteriaFactory.createLogicalCriteria("or", criteriaList);
//
//        System.out.println(CriteriaEvaluator.isMatch(orCriteria, input2));

        Map<String, Object> input3 = new HashMap<>();
        input3.put("age", 30);
        input3.put("name", "Dal");
        LogicalCriteria orCriteria = CriteriaFactory.createLogicalCriteria("not", criteriaList);

        System.out.println(CriteriaEvaluator.isMatch(orCriteria, input3));


    }
}
