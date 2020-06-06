package programmers;

public class Programmers_12903 {

	public static void main(String[] args) {
		solution("abcbaa");
	}
	public static String solution(String s) {
		String answer = "";
		if(s.length()%2==0) {
			answer = ""+s.charAt((s.length()/2)-1)+s.charAt((s.length()/2));
		} else {
			answer = ""+s.charAt(s.length()/2);
		}
        System.out.println(answer);
        return answer;
    }

}
