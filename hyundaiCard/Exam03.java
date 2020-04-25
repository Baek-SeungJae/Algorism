package hyundaiCard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam03 {
	public static void main(String[] args) {
		String[] registered_list = new String[] {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
		String new_id = "ace15";
		solution(registered_list,new_id);
	}

	public static String solution(String[] registered_list, String new_id) {
		String str = "abcde10101";
		Pattern p = Pattern.compile("[^a-z]{3,6}[0-9]{0,6}");
		Matcher m= p.matcher(str);
		m.find();
		System.out.println(m.matches());
		
		
		String answer = "";
		return answer;
	}
}
