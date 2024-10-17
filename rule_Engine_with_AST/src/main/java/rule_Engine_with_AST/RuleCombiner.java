package rule_Engine_with_AST;

public class RuleCombiner {
	/**
	 * Combines two AST rules with the given logical operator (AND/OR).
	 * 
	 * @param rule1    The first rule AST.
	 * @param rule2    The second rule AST.
	 * @param operator The logical operator to combine the rules ("AND", "OR").
	 * @return A new ASTNode representing the combined rule.
	 */
	public static ASTNode combineRules(ASTNode rule1, ASTNode rule2, String operator) {
		// Create a new operator node with rule1 as the left child and rule2 as the
		// right child
		return new ASTNode("operator", operator, rule1, rule2);
	}
}
