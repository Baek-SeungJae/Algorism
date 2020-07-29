package programmers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class programmers_60057 {

	public static void main(String[] args) {
		String s = "aabbaccc";
		System.out.println(solution(s));

	}

	public static int solution(String s) {
		/* 답이 될 수 있는 최소길이 */
		int min_size = s.length();
		
		/* 패턴에서 0은 의미가 없으므로 1부터 시작함 */
		for (int i = 1; i <= s.length(); i++) {
			/* 패턴에 해당하는 글자수를 순차적으로 증가시킴 */
			String patternStr = "[a-z]{" + i + "}";
			Pattern pattern = Pattern.compile(patternStr);
			Matcher m = pattern.matcher(s);
			/* 답이 될 수 있는 문자열을 위한 스트링빌더 */
			StringBuilder sb_all = new StringBuilder("");
			/* 연산과정에서 필요한 문자열을 위한 스트링빌더 */
			StringBuilder sb_temp = new StringBuilder("");
			/* 패턴이 몇번 반복됬는지 셀 카운터 */
			int count = 0;
			while (m.find()) {
				/* sb_temp와 비교할  스트링빌더 */
				StringBuilder sb_check = new StringBuilder(m.group());
				/* 이전과 이후 비교 같으면 카운터 증가 */
				if (sb_temp.toString().equals(sb_check.toString())) {
					count++;
				} else {
					/* 카운터가 0또는 1이 아니라면 답안문자열에 숫자 추가, 숫자가 패턴 앞에 와야하므로 지정된 위치에 숫자 삽입 */
					if (count != 1 && count != 0) {
						sb_all.insert(sb_all.length() - i, count);
					}
					/* 패턴이 반복되지 않으면 카운터는 1, 답안문자열에 패턴추가, sb_temp를 비움 */
					count = 1;
					sb_all.append(sb_check);
					sb_temp.delete(0, sb_temp.length());
				}
				System.out.println(sb_check);
				/* 다음 루프에서 비교를 위해 sb_check를 sb_temp에 복사함*/
				sb_temp = new StringBuilder(sb_check); 
			}
			/* 루프가 끝나고 마지막 연산, matcher에 잔여문자열이 무시되는 특성때문에*/
			if (count != 1 && count != 0) {
				sb_all.insert(sb_all.length() - i, count);
			}
			/* 마지막 잔여 문자열을 substring로 잘라내서 뭍여줌 */
			sb_all.append(s.substring(s.length()-s.length()%i));
			/* 문자열길이의 최소값을 구함*/
			min_size = Math.min(min_size, sb_all.length());
			/* 확인을 위한 sysout */
			System.out.println(sb_all.toString());
		}
		int answer = min_size;
		return answer;
	}
}
