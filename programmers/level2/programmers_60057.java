package programmers.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class programmers_60057 {

	public static void main(String[] args) {
		String s = "aabbaccc";
		System.out.println(solution(s));

	}

	public static int solution(String s) {
		/* ?΅?΄ ?  ? ?? μ΅μκΈΈμ΄ */
		int min_size = s.length();
		
		/* ?¨?΄?? 0?? ?λ―Έκ? ??Όλ―?λ‘? 1λΆ??° ???¨ */
		for (int i = 1; i <= s.length(); i++) {
			/* ?¨?΄? ?΄?Ή?? κΈ???λ₯? ?μ°¨μ ?Όλ‘? μ¦κ???΄ */
			String patternStr = "[a-z]{" + i + "}";
			Pattern pattern = Pattern.compile(patternStr);
			Matcher m = pattern.matcher(s);
			/* ?΅?΄ ?  ? ?? λ¬Έμ?΄? ?? ?€?Έλ§λΉ? */
			StringBuilder sb_all = new StringBuilder("");
			/* ?°?°κ³Όμ ?? ??? λ¬Έμ?΄? ?? ?€?Έλ§λΉ? */
			StringBuilder sb_temp = new StringBuilder("");
			/* ?¨?΄?΄ λͺλ² λ°λ³΅?¬?μ§? ?? μΉ΄μ΄?° */
			int count = 0;
			while (m.find()) {
				/* sb_temp?? λΉκ΅?   ?€?Έλ§λΉ? */
				StringBuilder sb_check = new StringBuilder(m.group());
				/* ?΄? κ³? ?΄? λΉκ΅ κ°μΌλ©? μΉ΄μ΄?° μ¦κ? */
				if (sb_temp.toString().equals(sb_check.toString())) {
					count++;
				} else {
					/* μΉ΄μ΄?°κ°? 0?? 1?΄ ???Όλ©? ?΅?λ¬Έμ?΄? ?«? μΆκ?, ?«?κ°? ?¨?΄ ?? ???Ό?λ―?λ‘? μ§?? ? ?μΉμ ?«? ?½? */
					if (count != 1 && count != 0) {
						sb_all.insert(sb_all.length() - i, count);
					}
					/* ?¨?΄?΄ λ°λ³΅?μ§? ??Όλ©? μΉ΄μ΄?°? 1, ?΅?λ¬Έμ?΄? ?¨?΄μΆκ?, sb_tempλ₯? λΉμ? */
					count = 1;
					sb_all.append(sb_check);
					sb_temp.delete(0, sb_temp.length());
				}
				System.out.println(sb_check);
				/* ?€? λ£¨ν?? λΉκ΅λ₯? ??΄ sb_checkλ₯? sb_temp? λ³΅μ¬?¨*/
				sb_temp = new StringBuilder(sb_check); 
			}
			/* λ£¨νκ°? ??κ³? λ§μ?λ§? ?°?°, matcher? ??¬λ¬Έμ?΄?΄ λ¬΄μ?? ?Ή?±?λ¬Έμ*/
			if (count != 1 && count != 0) {
				sb_all.insert(sb_all.length() - i, count);
			}
			/* λ§μ?λ§? ??¬ λ¬Έμ?΄? substringλ‘? ??Ό?΄? λ­μ¬μ€? */
			sb_all.append(s.substring(s.length()-s.length()%i));
			/* λ¬Έμ?΄κΈΈμ΄? μ΅μκ°μ κ΅¬ν¨*/
			min_size = Math.min(min_size, sb_all.length());
			/* ??Έ? ?? sysout */
			System.out.println(sb_all.toString());
		}
		int answer = min_size;
		return answer;
	}
}
