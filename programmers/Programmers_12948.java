package programmers;

public class Programmers_12948 {
	public static void main(String[] args) {
		String phone_number = "01033334444";
		System.out.println(solution(phone_number));
	}

	public static String solution(String phone_number) {
		char[] charArr = phone_number.toCharArray();
		for(int i=0; i<phone_number.length()-4;i++) {
			charArr[i] = '*';
		}
        String answer = new String(charArr);
        return answer;
    }
}