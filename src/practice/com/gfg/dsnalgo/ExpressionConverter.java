package practice.com.gfg.dsnalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionConverter {
	public Stack<Integer> operandStack = new Stack();
	public Stack operatorStack = new Stack();
	Integer value;
	
	boolean first = false;
	List<StringBuffer> list =new ArrayList<StringBuffer>();

	public int parseAndEvaluateExpression(String str) {
		
		for (int i = str.length() - 1; i >= 0; i--) {
			if (isDigit(str.charAt(i))) {
				operandStack.push(Character.getNumericValue(str.charAt(i)));
			} else if (str.charAt(i) == '(' && !operandStack.isEmpty() && !operatorStack.isEmpty()) {
				Integer opearnd1 = operandStack.pop();
				Integer opearnd2 = operandStack.pop();
				String operator = Character.toString((char) operatorStack.peek());
				addExpression(opearnd1, opearnd2, operator);
				value = getValue(opearnd1, opearnd2, operator);
				operandStack.push(value);
				if (operatorStack.size() > 1 || i > 0) {
					operatorStack.pop();
				} else if (operatorStack.size() == 1 && !operandStack.isEmpty() && !operatorStack.isEmpty()) {
					opearnd1 = operandStack.pop();
					opearnd2 = operandStack.pop();
					operator = Character.toString((char) operatorStack.peek());
					// expression = (getExpression(opearnd1, opearnd2,
					// operator));
					value = getValue(opearnd1, opearnd2, operator);
					operandStack.push(value);
				}
			} else if (isOperator(str.charAt(i))) {
				operatorStack.push(str.charAt(i));
			}
		}
		return value;
	}

	private boolean isOperator(char charAt) {
		if (charAt == '+' || charAt == '-' || charAt == '*' || charAt == '/')
			return true;
		return false;
	}

	private Integer getValue(Integer opearnd1, Integer opearnd2, String operator) {
		int value = 0;
		switch (operator) {
		case "+":
			value = opearnd1 + opearnd2;
			break;
		case "-":
			value = opearnd1 - opearnd2;
			break;
		case "*":
			value = opearnd1 * opearnd2;
			break;
		case "/":
			if (opearnd2 != 0)
				value = opearnd1 / opearnd2;
			else {
				System.out.println("Divisor can't be zero");
				break;
			}
			break;
		}
		return value;
	}

	private boolean addExpression(Integer opearnd1, Integer opearnd2, String operator) {
		/*if (first == false) {
			expression.append(" ( " + opearnd1 + " " + operator + " " + opearnd2 + " ) ");
			first = true;
		} else {
			expression.append(operator).append(" ( " + opearnd1 + " " + operator + " " + opearnd2 + " ) ");

		}
		return expression;*/
		StringBuffer expression = new StringBuffer();
		/*expression.delete(0, expression.length());*/
		expression.append(" ( " + opearnd1 + " " + operator + " " + opearnd2 + " ) ");
		list.add(expression);
		return true;

	}

	private boolean isDigit(char charAt) {
		if (Character.getNumericValue(charAt) < 9 && Character.getNumericValue(charAt) > 0)
			return true;
		else
			return false;
	}
	public StringBuffer getExpression(){
		StringBuffer sBuffer=new StringBuffer();
		String operator = Character.toString((char) operatorStack.peek());
		for(int i=0;i<list.size();i++){
			if(i!=list.size()-1)
			sBuffer.append(list.get(i)).append(operator);
			else
				sBuffer.append(list.get(i));
		}
		return sBuffer;
		
	}

	public static void main(String[] args) {
		String input = "(+3(*52)(-63))";
		ExpressionConverter expc = new ExpressionConverter();
		System.out.println(expc.parseAndEvaluateExpression(input));
		System.out.println(expc.getExpression());
	}
}
