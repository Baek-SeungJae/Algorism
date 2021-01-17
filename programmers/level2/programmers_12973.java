package programmers.level2;

import java.util.Stack;

public class programmers_12973 {

    public static void main(String[] args) {
        String s1 = "baabaa";
        String s2 = "cdcd";
        System.out.println(solution(s1));
        System.out.println(solution(s2));

    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< s.length(); i++){
            if(!stack.isEmpty()){
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                } else {
                    stack.add(s.charAt(i));
                }
            } else {
                stack.add(s.charAt(i));
            }
        }
        if(stack.isEmpty()){
            return 1;
        } else {
            return 0;
        }
    }
}
