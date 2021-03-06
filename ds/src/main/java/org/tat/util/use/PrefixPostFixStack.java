package org.tat.util.use;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.tat.util.Stack;

public class PrefixPostFixStack {

	public String inFixToPostFix(String input, String delemeter) {
		Stack<String> stack = new Stack<String>(input.length());
		StringBuffer sf = new StringBuffer();
		StringTokenizer st = new StringTokenizer(input, delemeter);
		String token = null;
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			if (isOperand(token)) {
				sf.append(token).append(delemeter);
			} else if (isOperator(token)) {
				if (stack.getTop() > -1) {
					while (isOperator(stack.peek())
							&& operatorPrecedence(stack.peek()) >= operatorPrecedence(token)) {
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

	public String inFixToPreFix(String input, String delemeter) {
		input = new StringBuffer(input).reverse().toString();
		StringTokenizer st = new StringTokenizer(input, delemeter);
		String token = null;
		StringBuffer sb = new StringBuffer();
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			if (isOpenParanthesis(token)) {
				sb.append(findMachingParanthesis(token)).append(delemeter);
			} else if (isCloseParanthesis(token)) {
				sb.append(findMachingParanthesis(token)).append(delemeter);
			} else {
				sb.append(token).append(delemeter);
			}
		}

		input = this
				.inFixToPostFix(sb.substring(0, sb.length() - 1), delemeter);
		return new StringBuffer(input).reverse().toString();

	}
	
	public String evalPostFix(String input, String delemeter){
		Stack<String> stack = new Stack<String>(input.length());
		StringBuffer sf = null;
		StringTokenizer st = new StringTokenizer(input, delemeter);
		String token = null;
		String operand1, operand2;
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			if(isOperand(token)){
				stack.push(token);
			}else{
				sf = new StringBuffer();
				operand2 = stack.pop();
				operand1 = stack.pop();
				sf.append(operand1);
				sf.append(token);
				sf.append(operand2);
				stack.push(evaluateExpression(sf.toString())+"");
			}
		}
		return stack.pop();
	}
	
	public String evalPreFix(String input, String delemeter){
		Stack<String> stack = new Stack<String>(input.length());
		StringBuffer sf = new StringBuffer(input);
		input = sf.reverse().toString();
		StringTokenizer st = new StringTokenizer(input, delemeter);
		String token = null;
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			if(isOperand(token)){
				stack.push(token);
			}else{
				sf = new StringBuffer();
				sf.append(stack.pop());
				sf.append(token);
				sf.append(stack.pop());
				stack.push(evaluateExpression(sf.toString())+"");
			}
		}
		return stack.pop();
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
		case "[":
			output = "]";
			break;
		case "}":
			output = "{";
			break;
		case "{":
			output = "}";
			break;
		case ")":
			output = "(";
			break;
		case "(":
			output = ")";
			break;
		default:
			throw new RuntimeException("Invalid Paranthesis : " + input);
		}
		return output;
	}
	
	private int evaluateExpression(String input){
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    try {
			return ((Double)engine.eval(input)).intValue();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
