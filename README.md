# Rule Engine with Abstract Syntax Tree (AST)

## Overview
This project is a simple 3-tier rule engine application that determines user eligibility based on various attributes such as age, department, salary, and experience. The system dynamically creates and evaluates rules using an Abstract Syntax Tree (AST), allowing flexible combinations and modifications of rules.

## Features
- Parse complex conditional rules into an AST.
- Combine multiple rules using logical operators (AND, OR).
- Evaluate rules against user-provided data.
- Dynamically modify rules by changing operands or operators.

## Example Rules

Here are some sample rules that can be parsed and evaluated:

- **Rule 1**: ((age > 30 AND department = 'Sales') OR (age < 25 AND department = 'Marketing')) 
AND (salary > 50000 OR experience > 5)
- **Rule 2**: ((age > 30 AND department = 'Marketing')) 
AND (salary > 20000 OR experience > 5)




 ## Technologies Used
- **Java 8+**: For core logic and development.
- **Maven**: For project build and dependency management.
- **JUnit**: For unit testing.
## Project Structure
```bash
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── rule_Engine_with_AST
│   │   │   │   ├── Main.java         // Entry point of the application
│   │   │   │   ├── ASTNode.java       // AST Node structure
│   │   │   │   ├── RuleParser.java    // Parser for converting rule strings to AST
│   │   │   │   ├── RuleEvaluator.java // Evaluates the rules using the AST
│   │   │   │   ├── RuleCombiner.java  // Combines multiple rules into a single AST
│   └── test
│       ├── java
│       └── rule_Engine_with_AST
│           └── RuleEngineTest.java    // Unit tests for rule engine functionalities
└── README.md                         // This file
```
 ## Installation and Setup
- **Clone the Repository**:
  ```bash
  git clone https://github.com/bhaskarradha123/rule-engine-ast.git
  cd rule-engine-ast
  ```
  
- **Build the Project**: Ensure that you have Maven installed. Then, run the following command to build the project:

   ```bash
   mvn clean install

   ``` 
- **Run the Application**: After building, run the main class to execute the application:

   ```bash
   mvn exec:java -Dexec.mainClass="rule_Engine_with_AST.Main"
   ```

## How It Works
- **AST Representation**: Each rule is represented as an abstract syntax tree (AST), where each node can be either an operator (AND, OR) or a condition (age > 30).
- **Combining Rules**: Multiple rules can be combined using the RuleCombiner class, which joins the ASTs of individual rules using logical operators.
- **Rule Evaluation**: Once a rule is parsed into an AST, the RuleEvaluator class recursively evaluates the AST against user-provided data.

## Features
1.Create and combine rules:
  ```bash
ASTNode rule1 = RuleParser.createRule(rule1String);
ASTNode rule2 = RuleParser.createRule(rule2String);
ASTNode combinedRule = RuleCombiner.combineRules(rule1, rule2, "AND");

  ```
2.Evaluate rules:
  ```bash
Map<String, Object> userData = new HashMap<>();
userData.put("age", 35);
userData.put("department", "Sales");
userData.put("salary", 60000);
userData.put("experience", 3);

boolean isEligible = RuleEvaluator.evaluateRule(combinedRule, userData);
System.out.println("User eligibility: " + isEligible);


  ```
## Running Tests
To run the unit tests, execute the following command:
```bash
mvn test
```

## Future Improvements
- Support for more complex rule expressions.
- Rule modification and versioning capabilities.
- Error handling for malformed rule strings
- Support for user-defined functions within the rule language.




