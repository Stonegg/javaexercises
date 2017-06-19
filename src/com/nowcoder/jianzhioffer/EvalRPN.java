package com.nowcoder.jianzhioffer;

import java.util.Stack;
/**
 * 剑指offer题目：
 * @author Stone
 *
 */
public class EvalRPN {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(calc(num1, num2, tokens[i]));
			}
			else {
				int num =Integer.parseInt(tokens[i]);
				stack.push(num);
			}
		}
		return stack.pop();
	}
	private int calc(int a, int b, String operator) {
		switch (operator) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "*":
			return a * b;
		case "/":
			return a / b;
		default :
			return 0;
		}
	}
	public static void main(String[] args) {
		String[] tokens = { "0","3","/"};
		EvalRPN solution = new EvalRPN();
		int n = solution.evalRPN(tokens);
		System.out.println(n);
		
	}

}
