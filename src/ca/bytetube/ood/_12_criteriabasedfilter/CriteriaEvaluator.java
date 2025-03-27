package ca.bytetube.ood._12_criteriabasedfilter;

import java.util.Map;

//这个类用来调用isMatch(),确认数据是否匹配某个Criteria
public class CriteriaEvaluator {
    public static boolean isMatch(Criteria criteria, Map<String, Object> input) {
        return criteria.isMatch(input);
    }

}
