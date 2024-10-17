package rule_Engine_with_AST;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RuleEvaluator {
	public static boolean evaluateRule(ASTNode node, Map<String, Object> data) {
		if (node.type.equals("operator")) {
			if (node.operator.equals("AND")) {
				return evaluateRule(node.left, data) && evaluateRule(node.right, data);
			} else if (node.operator.equals("OR")) {
				return evaluateRule(node.left, data) || evaluateRule(node.right, data);
			}
		} else if (node.type.equals("operand")) {
			return evaluateCondition(node.condition, data);
		}
		return false;

	}

	private static boolean evaluateCondition(String condition, Map<String, Object> data) {
	    // Remove parentheses and trim the condition
	    condition = condition.replaceAll("[()]", "").trim();

	    // Use regex to handle both numeric and string comparisons
	    String regex = "(\\w+)\\s*(==|>|<|=)\\s*('?\\w+'?|\\d+)";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(condition);

	    if (matcher.matches()) {
	        String attribute = matcher.group(1); // Attribute name
	        String operator = matcher.group(2);  // Operator
	        String value = matcher.group(3);     // Value (could be number or string)

	        // Check if the attribute exists in the data
	        if (!data.containsKey(attribute)) return false;

	        Object dataValue = data.get(attribute);

	        // If the data value is a number, compare numerically
	        if (dataValue instanceof Integer) {
	            int numericValue = Integer.parseInt(value);
	            int dataIntValue = (int) dataValue;

	            // Evaluate the condition
	            switch (operator) {
	                case ">":
	                    return dataIntValue > numericValue;
	                case "<":
	                    return dataIntValue < numericValue;
	                case "=":
	                case "==":
	                    return dataIntValue == numericValue;
	                default:
	                    return false;
	            }
	        } else if (dataValue instanceof String) {  // If the data value is a string, compare as strings
	            String dataStrValue = (String) dataValue;

	            // Remove any quotes around the value
	            value = value.replace("'", "");

	            // Evaluate the string comparison
	            return dataStrValue.equals(value);
	        }
	    } else {
	        throw new IllegalArgumentException("Invalid condition format: " + condition);
	    }

	    return false;
	}

}
