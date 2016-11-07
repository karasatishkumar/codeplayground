package org.tat.java8;

interface MathOperation {
	int operation(int a, int b);
}

interface GreetingService {
	void sayMessage(String message);
}

public class LambdaExample {
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	public static void main(String[] args) {
		LambdaExample le = new LambdaExample();

		// With type declaration
		MathOperation addition = (int a, int b) -> a + b;

		// With out type declaration
		MathOperation substration = (a, b) -> a - b;

		// With return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {
			a = 10;
			return a * b;
		};

		// with out return statement and with out curly braces
		MathOperation division = (int a, int b) -> a / b;
		
		System.out.println("Adding 5 + 6 : " + le.operate(5, 6, addition));
		System.out.println("Substracting 6 - 3 : " + le.operate(6, 3, substration));
		System.out.println("Multiplication 6 * 3 : " + le.operate(6, 3, multiplication));
		System.out.println("Division 6 / 3 : " + le.operate(6, 3, division));
		
		//with out paranthesis
		GreetingService gs1 = message -> System.out.println("Message is  : " + message);
		
		//with paranthesis
		GreetingService gs2 = (message) -> System.out.println("Message is : (" + message + ")");
		
		gs1.sayMessage("Satish");
		gs2.sayMessage("Suchi");
	}
}
