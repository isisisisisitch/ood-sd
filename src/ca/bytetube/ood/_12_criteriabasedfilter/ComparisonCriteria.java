package ca.bytetube.ood._12_criteriabasedfilter;

import java.util.Map;

public class ComparisonCriteria extends Criteria {
    private String name;
    private Object value;

    public ComparisonCriteria(String name, Object value, String operator) {
        super(operator);
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean isMatch(Map<String, Object> input) {
        if (input == null || !input.containsKey(name)) return false;
        Object inputVal = input.get(name);
        switch (operator) {
            case "==":
                return inputVal.equals(value);

            case "!=":
                return !inputVal.equals(value);
            case ">":
                if (inputVal instanceof Number && value instanceof Number) {
                    return ((Number) inputVal).doubleValue() > ((Number) value).doubleValue();
                }
                break;
            case "<":
                if (inputVal instanceof Number && value instanceof Number) {
                    return ((Number) inputVal).doubleValue() < ((Number) value).doubleValue();
                }
                break;
        }

        return false;
    }
}
