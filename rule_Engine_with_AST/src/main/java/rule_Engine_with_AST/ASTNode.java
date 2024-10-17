package rule_Engine_with_AST;

class ASTNode {
	String type; // "operator" for AND/OR, "operand" for condition
	String operator; // AND, OR (if it's an operator node)
	String condition; // "age > 30" (if it's an operand node)
	ASTNode left; // Left child (for operators)
	ASTNode right; // Right child (for operators)

	public ASTNode(String type, String operator, ASTNode left, ASTNode right) {
		this.type = type;
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	public ASTNode(String type, String condition) {
		this.type = type;
		this.condition = condition;
	}

	

}
