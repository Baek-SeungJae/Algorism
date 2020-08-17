package programmers.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class programmers_60057 {

	public static void main(String[] args) {
		String s = "aabbaccc";
		System.out.println(solution(s));

	}

	public static int solution(String s) {
		/* ?��?�� ?�� ?�� ?��?�� 최소길이 */
		int min_size = s.length();
		
		/* ?��?��?��?�� 0?? ?��미�? ?��?���?�? 1�??�� ?��?��?�� */
		for (int i = 1; i <= s.length(); i++) {
			/* ?��?��?�� ?��?��?��?�� �??��?���? ?��차적?���? 증�??��?�� */
			String patternStr = "[a-z]{" + i + "}";
			Pattern pattern = Pattern.compile(patternStr);
			Matcher m = pattern.matcher(s);
			/* ?��?�� ?�� ?�� ?��?�� 문자?��?�� ?��?�� ?��?��링빌?�� */
			StringBuilder sb_all = new StringBuilder("");
			/* ?��?��과정?��?�� ?��?��?�� 문자?��?�� ?��?�� ?��?��링빌?�� */
			StringBuilder sb_temp = new StringBuilder("");
			/* ?��?��?�� 몇번 반복?��?���? ?? 카운?�� */
			int count = 0;
			while (m.find()) {
				/* sb_temp?? 비교?��  ?��?��링빌?�� */
				StringBuilder sb_check = new StringBuilder(m.group());
				/* ?��?���? ?��?�� 비교 같으�? 카운?�� 증�? */
				if (sb_temp.toString().equals(sb_check.toString())) {
					count++;
				} else {
					/* 카운?���? 0?��?�� 1?�� ?��?��?���? ?��?��문자?��?�� ?��?�� 추�?, ?��?���? ?��?�� ?��?�� ???��?���?�? �??��?�� ?��치에 ?��?�� ?��?�� */
					if (count != 1 && count != 0) {
						sb_all.insert(sb_all.length() - i, count);
					}
					/* ?��?��?�� 반복?���? ?��?���? 카운?��?�� 1, ?��?��문자?��?�� ?��?��추�?, sb_temp�? 비�? */
					count = 1;
					sb_all.append(sb_check);
					sb_temp.delete(0, sb_temp.length());
				}
				System.out.println(sb_check);
				/* ?��?�� 루프?��?�� 비교�? ?��?�� sb_check�? sb_temp?�� 복사?��*/
				sb_temp = new StringBuilder(sb_check); 
			}
			/* 루프�? ?��?���? 마�?�? ?��?��, matcher?�� ?��?��문자?��?�� 무시?��?�� ?��?��?��문에*/
			if (count != 1 && count != 0) {
				sb_all.insert(sb_all.length() - i, count);
			}
			/* 마�?�? ?��?�� 문자?��?�� substring�? ?��?��?��?�� 뭍여�? */
			sb_all.append(s.substring(s.length()-s.length()%i));
			/* 문자?��길이?�� 최소값을 구함*/
			min_size = Math.min(min_size, sb_all.length());
			/* ?��?��?�� ?��?�� sysout */
			System.out.println(sb_all.toString());
		}
		int answer = min_size;
		return answer;
	}
}
