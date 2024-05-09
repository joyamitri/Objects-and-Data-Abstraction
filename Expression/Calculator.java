package Expression;

/*
_______________________________________________________________________________________________________________________

Program Description: This program's aim is to manage a Calculator

_______________________________________________________________________________________________________________________

*/

public class Calculator {
    // This class has a static method calculator that uses stacks to calculate a
	// fully parenthesized equation
	public static Double calculate(String s) {
		// calculates a fully parenthesized expression is an arithmetic expression
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		String topush = "";
		String operator = "";
		double a1;
		double a2;
		for (int i = 0; i < s.length(); i++) {
			// go through the string character by character, skip (, save operands in s1,
			// operators in s2.
			// when ) is encountered, dequeue twice from s1, once from s2, do the operation,
			// enqueue the answer back in s1.
			if (s.charAt(i) == '(') {

			} else if ((s.charAt(i) == ')')) {
				if (topush != "") {
					s1.push(topush);
					topush = "";
				}
				a2 = Double.parseDouble(s1.pop());
				a1 = Double.parseDouble(s1.pop());
				operator = s2.pop();
				switch (operator) {
				case "+":
					a1 = a1 + a2;
					s1.push("" + a1);
					break;
				case "-":
					a1 = a1 - a2;
					s1.push("" + a1);
					break;
				case "*":
					a1 = a1 * a2;
					s1.push("" + a1);
					break;
				case "/":
					a1 = a1 / a2;
					s1.push("" + a1);
					break;
				case "%":
					a1 = a1 % a2;
					s1.push("" + a1);
					break;
				}
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'
					|| s.charAt(i) == '%') {
				if (topush != "") {
					s1.push(topush);
					topush = "";
				}
				operator = "" + s.charAt(i);
				s2.push(operator);
			} else {
				topush = topush + s.charAt(i);
			}
		}
		return Double.parseDouble(s1.pop());
	}

	public static void main(String[] args) {
		// testing
		String e = "(((1+99)*(5/2))+((1/5)-(6%7)))";
		System.out.println(e + "=" + calculate(e));

	}
}
