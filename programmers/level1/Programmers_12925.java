package programmers.level1;

public class Programmers_12925 {
	public static void main(String[] args) {
		String s = "+1234";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
        int result;
        if(s.charAt(0)=='+'){
            result = Integer.parseInt(s.substring(1));
        } else {
            result = Integer.parseInt(s);
        }
        return result;
    }
}