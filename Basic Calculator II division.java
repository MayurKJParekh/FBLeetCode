//leetcode 227 Basic Calculator II

/*
time: O(n)
space: O(1)
*/
class Solution {
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        long prevNum = 0;
        int sum = 0;
        char prevOp = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                int val = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    val = val * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                if (prevOp == '+') {
                    sum += prevNum;
                    prevNum = val;
                } else if (prevOp == '-') {
                    sum += prevNum;
                    prevNum = -val;
                } else if (prevOp == '*') {
                    prevNum = prevNum * val;
                } else if (prevOp == '/') {
                    prevNum = prevNum / val;
                }
            } else {
                prevOp = c;
            }
        }
        
        sum += prevNum;
        return sum;
    }
}

/*
time: O(n)
space: O(n)
*/
public class Solution {
	public int calculate(String s) {
		int len;
	    if (s == null || (len = s.length()) == 0) return 0;
	    Stack<Integer> stack = new Stack<Integer>();
	    int num = 0;
	    char sign = '+';
	    for (int i = 0; i < len; i++) {
	        if (Character.isDigit(s.charAt(i))) {
	            num = num * 10 + s.charAt(i) - '0';
	        }
	        if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == len - 1) {
	            if (sign == '-') {
	                stack.push(-num);
	            }
	            if (sign == '+') {
	                stack.push(num);
	            }
	            if (sign == '*') {
	                stack.push(stack.pop() * num);
	            }
	            if (sign == '/') {
	                stack.push(stack.pop() / num);
	            }
	            sign = s.charAt(i);
	            num = 0;
	        }
	    }

	    int res = 0;
	    for (int i : stack) {
	        res += i;
	    }
	    return res;
    }
}

/*
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
*/
