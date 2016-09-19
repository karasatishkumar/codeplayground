package org.tat.util.use;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.tat.util.Stack;

public class PrefixPostFixStack {

	public String inFixToPostFix(String input, String delemeter) {
		Stack<String> stack = new Stack<String>(input.length());
		StringBuffer sf = new StringBuffer();
		StringTokenizer st = new StringTokenizer(input, delemeter);
		// for (int i = 0; i < input.length(); i++) {
		String token = null;
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			// if input[i] is a operand append to string builder

			// if input[i] is operator peek the stack and check for oprator
			// precedence
			// if peek operator is of higher precedence the pop.. do it until
			// you find a pranthesis or operator of lower precedence
			// else push to the stact

			// if input is open paranthesis push the stact
			// if input is the close then pop till you find a close

			if (isOperand(token)) {
				sf.append(token).append(delemeter);
			} else if (isOperator(token)) {
				if (stack.getTop() > -1) {
					while (isOperator(stack.peek())
							&& operatorPrecedence(stack.peek()) > operatorPrecedence(token)) {
						sf.append(stack.pop()).append(delemeter);
					}
				}

				stack.push(token);
			} else if (isOpenParanthesis(token)) {
				stack.push(token);
			} else if (isCloseParanthesis(token)) {
				while (!stack.peek().equals(findMachingParanthesis(token))) {
					sf.append(stack.pop()).append(delemeter);
				}
				stack.pop();
			}
		}
		while (stack.getTop() > -1) {
			sf.append(stack.pop()).append(delemeter);
		}
		return sf.toString().substring(0, sf.length() - 1);
	}

	private boolean isOperand(String input) {
		Pattern p = Pattern.compile("([A-Z]|[a-z]|[0-9]+)");
		Matcher m = p.matcher(input);
		return m.find();
	}

	private boolean isOperator(String input) {
		if (input.equals("+") || input.equals("-") || input.equals("*")
				|| input.equals("/") || input.equals("^"))
			return true;
		return false;
	}

	private boolean isOpenParanthesis(String input) {
		if (input.equals("(") || input.equals("{") || input.equals("["))
			return true;
		return false;
	}

	private boolean isCloseParanthesis(String input) {
		if (input.equals(")") || input.equals("}") || input.equals("]"))
			return true;
		return false;
	}

	private int operatorPrecedence(String input) {
		int output = 0;
		switch (input) {
		case "+":
		case "-":
			output = 1;
			break;
		case "*":
		case "/":
			output = 2;
			break;
		case "^":
			output = 3;
			break;
		default:
			throw new RuntimeException("Invalid Operator : " + input);
		}
		return output;
	}

	private String findMachingParanthesis(String input) {
		String output;
		switch (input) {
		case "]":
			output = "[";
			break;
		case "}":
			output = "{";
			break;
		case ")":
			output = "(";
			break;
		default:
			throw new RuntimeException("Invalid Paranthesis : " + input);
		}
		return output;
	}
}
