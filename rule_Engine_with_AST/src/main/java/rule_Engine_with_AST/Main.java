package rule_Engine_with_AST;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create rules
        String rule1String = "((age > 30 AND department = 'Sales') OR (age < 25 AND department = 'Marketing')) AND (salary > 50000 OR experience > 5)";
        String rule2String = "((age > 30 AND department = 'Marketing')) AND (salary > 20000 OR experience > 5)";
        
        ASTNode rule1 = RuleParser.createRule(rule1String);
        ASTNode rule2 = RuleParser.createRule(rule2String);

        // Step 2: Combine rules (for now just evaluating them separately for simplicity)
        ASTNode combinedRule = RuleCombiner.combineRules(rule1, rule2, "AND");

        // Step 3: Prepare user data
        Map<String, Object> userData = new HashMap<>();
        userData.put("age", 35);
        userData.put("department", "Sales");
        userData.put("salary", 60000);
        userData.put("experience", 3);

        // Step 4: Evaluate rule
        boolean isEligible = RuleEvaluator.evaluateRule(combinedRule, userData);
        System.out.println("User eligibility: " + isEligible);
    
}

}

