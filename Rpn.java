// Reverse Polish notation

import java.util.Stack;
import java.util.HashMap;
import java.util.Scanner;
import java.util.EmptyStackException;

public class Rpn
{
    private static final HashMap <Character, Integer> priority;

    static
    {
	priority = new HashMap <>();
	priority.put('^', 3);
	priority.put('*', 2);
	priority.put('/', 2);
	priority.put('+', 1);
	priority.put('-', 1);
    }

    public static String InfixToPostfix(String expr)
    {
	Stack <Character> op = new Stack <>();
	StringBuilder outstr = new StringBuilder();
	char ch;
	
	for(int i = 0; i < expr.length(); i++) {
	    ch = expr.charAt(i);
	    if(Character.isWhitespace(ch))
		;
	    else if(Character.isDigit(ch))
		outstr.append(ch);
	    else if(ch == '(')
		op.push(ch);
	    else if(ch == ')') {
		while(!op.empty() && (ch = op.pop()) != '(') {
		    outstr.append(' ');
		    outstr.append(ch);
		}
		if(ch != '(') {
		    System.err.println("Error. Parentheses are not consistent");
		    return null;
		}
	    }
	    else if(priority.containsKey(ch)) {
		while(!op.empty() && op.peek() != '(' &&
		      priority.get(op.peek()) >= priority.get(ch)) {
		    outstr.append(' ');
		    outstr.append(op.pop());
		}
		outstr.append(' ');
		op.push(ch);
	    }
	    else {
		System.err.println("Error. Unexpected character in expression");
		return null;
	    }
	}
	
	while(!op.empty()) {
	    if(op.peek() == '(') {
		System.err.println("Error. Parentheses are not consistent ");
	        return null;
	    }
	    outstr.append(' ');
	    outstr.append(op.pop());
	}
	
	return outstr.toString();
    }

    public static int Evaluate(String expr)
    {
	Scanner in = new Scanner(expr);
	Stack <Integer> val = new Stack <>();
	String token;
	int op1, op2;

	while(in.hasNext()) {
	    token = in.next();
	    try {
		switch(token) {
		case "^":
		    op2 = val.pop();
		    op1 = val.pop();
		    val.push((int) Math.pow(op1, op2));
		    break;
		case "*":
		    val.push(val.pop() * val.pop());
		    break;
		case "/":
		    op2 = val.pop();
		    op1 = val.pop();
		    val.push(op1 / op2);
		    break;
		case "+":
		    val.push(val.pop() + val.pop());
		    break;
		case "-":
		    op2 = val.pop();
		    op1 = val.pop();
		    val.push(op1 - op2);
		    break;
		default:
		    val.push(Integer.parseInt(token));
		    break;
		}
	    }
	    catch(EmptyStackException e) {
		System.err.println("Error. Unexpected " + token + " in expression");
		return -1;
	    }
	    catch(ArithmeticException e) {
		System.err.println("Error. Probably you've made a division by zero");
		return -1;
	    }
	}

	return val.pop();
    }
}
