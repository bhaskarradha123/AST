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

