package org.tat.util.use;

import org.tat.util.Stack;

public class PrefixPostFixStack {

	public String inFixToPostFix(String input) {
		Stack<Character> stack = new Stack<Character>(input.length());
		StringBuffer sf = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			// if input[i] is a operand append to string builder
			
			// if input[i] is operator peek the stack and check for oprator
			// precedence
			// if peek operator is of higher precedence the pop.. do it until
			// you find a pranthesis or operator of lower precedence
			// else push to the stact
			
			// if input is open paranthesis push the stact
			// if input is the close then pop till you find a close 
			
			if(isOperand(input.charAt(i))){
				sf.append(input.charAt(i));
			}else if(isOperator(input.charAt(i))){
				if(stack.getTop() > -1){
					while(isOperator(stack.peek()) && operatorPrecedence(stack.peek()) > operatorPrecedence(input.charAt(i))){
						sf.append(stack.pop());
					}
				}
				
				stack.push(input.charAt(i));
			}else if(isOpenParanthesis(input.charAt(i))){
				stack.push(input.charAt(i));
			}else if(isCloseParanthesis(input.charAt(i))){
				while(!stack.peek().equals(findMachingParanthesis(input.charAt(i)))){
					sf.append(stack.pop());
				}
				stack.pop();
			}
		}
		while(stack.getTop() > -1){
			sf.append(stack.pop());
		}
		return sf.toString();
	}

	private boolean isOperand(Character input) {
		if((input >= 'a' && input <= 'z') || (input >= 'A' && input <= 'Z') || (input >= '0' && input <= '9'))
			return true;
		return false;
	}

	private boolean isOperator(Character input) {
		if(input == '+' || input == '-' || input == '*' || input == '/' || input == '^')
			return true;
		return false;
	}
	
	private boolean isOpenParanthesis(Character input){
		if(input == '(' || input == '{' || input == '[')
			return true;
		return false;
	}
	
	private boolean isCloseParanthesis(Character input){
		if(input == ')' || input == '}' || input == ']')
			return true;
		return false;
	}

	private int operatorPrecedence(Character input) {
		int output = 0;
		switch (input) {
		case '+':
		case '-':
			output = 1;
			break;
		case '*':
		case '/':
			output = 2;
			break;
		case '^':
			output = 3;
			break;
		default:
			throw new RuntimeException("Invalid Operator : " + input);
		}
		return output;
	}

	private Character findMachingParanthesis(Character input) {
		Character output;
		switch (input) {
		case ']':
			output = '[';
			break;
		case '}':
			output = '{';
			break;
		case ')':
			output = '(';
			break;
		default:
			throw new RuntimeException("Invalid Paranthesis : " + input);
		}
		return output;
	}

}
