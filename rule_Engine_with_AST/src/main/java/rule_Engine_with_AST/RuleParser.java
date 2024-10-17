package rule_Engine_with_AST;


public class RuleParser {
    public static ASTNode createRule(String rule) {
        rule = rule.trim();

        // If rule contains AND or OR, split by them and recursively create nodes
        if (rule.contains("AND")) {
            String[] parts = rule.split("AND", 2);
            ASTNode left = createRule(parts[0].trim());
            ASTNode right = createRule(parts[1].trim());
            return new ASTNode("operator", "AND", left, right);
        } else if (rule.contains("OR")) {
            String[] parts = rule.split("OR", 2);
            ASTNode left = createRule(parts[0].trim());
            ASTNode right = createRule(parts[1].trim());
            return new ASTNode("operator", "OR", left, right);
        } else {
            // It's a simple condition like "age > 30"
            return new ASTNode("operand", rule);
        }
    }
}



