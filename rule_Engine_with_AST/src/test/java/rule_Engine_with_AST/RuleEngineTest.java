package rule_Engine_with_AST;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class RuleEngineTest {

	@Test
	public void testSimpleRule() {
		String rule1String = "age > 30 AND salary > 50000";
		ASTNode rule1 = RuleParser.createRule(rule1String);

		Map<String, Object> data = new HashMap<>();
		data.put("age", 35);
		data.put("salary", 60000);

		boolean result = RuleEvaluator.evaluateRule(rule1, data);
		Assert.assertTrue(result);
	}

	@Test
	public void testCombinedRules() {
		String rule1String = "(age > 30 AND department = 'Sales') OR (age < 25 AND department = 'Marketing')";
		ASTNode rule1 = RuleParser.createRule(rule1String);

		Map<String, Object> data = new HashMap<>();
		data.put("age", 22);
		data.put("department", "Marketing");

		boolean result = RuleEvaluator.evaluateRule(rule1, data);
		Assert.assertTrue(result);
	}
}
