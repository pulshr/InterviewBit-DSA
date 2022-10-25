/**
Problem Description
Given string A denoting an infix expression. Convert the infix expression into a postfix expression.

String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.

Find and return the postfix expression of A.

NOTE:

^ has the highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.


Problem Constraints
1 <= length of the string <= 500000

Input Format
The only argument given is string A.

Output Format
Return a string denoting the postfix conversion of A.

Example Input

Input 1:

 A = "a+b*(c^d-e)^(f+g*h)-i"

Output 2:

"abcd^e-fgh*+^*+i-"
**/

public class InfixToPostfix {
    public String solve(String A) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('^',3);
        map.put('/',2);
        map.put('*',2);
        map.put('+',1);
        map.put('-',1);
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<A.length();i++) {
            char c = A.charAt(i);
            if(c>='a' && c<='z') {
                ans.append(c);
            } else if(c=='(') {
                stack.push(c);
            } else if(c==')') {
                while(stack.peek()!='(') {
                    ans.append(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && stack.peek()!='(' && map.get(c)<=map.get(stack.peek())) {
                    ans.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.toString();  
    }
}
