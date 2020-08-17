package programmers.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class programmers_60057 {

	public static void main(String[] args) {
		String s = "aabbaccc";
		System.out.println(solution(s));

	}

	public static int solution(String s) {
		/* ?‹µ?´ ?  ?ˆ˜ ?ˆ?Š” ìµœì†Œê¸¸ì´ */
		int min_size = s.length();
		
		/* ?Œ¨?„´?—?„œ 0?? ?˜ë¯¸ê? ?—†?œ¼ë¯?ë¡? 1ë¶??„° ?‹œ?‘?•¨ */
		for (int i = 1; i <= s.length(); i++) {
			/* ?Œ¨?„´?— ?•´?‹¹?•˜?Š” ê¸???ˆ˜ë¥? ?ˆœì°¨ì ?œ¼ë¡? ì¦ê??‹œ?‚´ */
			String patternStr = "[a-z]{" + i + "}";
			Pattern pattern = Pattern.compile(patternStr);
			Matcher m = pattern.matcher(s);
			/* ?‹µ?´ ?  ?ˆ˜ ?ˆ?Š” ë¬¸ì?—´?„ ?œ„?•œ ?Š¤?Š¸ë§ë¹Œ?” */
			StringBuilder sb_all = new StringBuilder("");
			/* ?—°?‚°ê³¼ì •?—?„œ ?•„?š”?•œ ë¬¸ì?—´?„ ?œ„?•œ ?Š¤?Š¸ë§ë¹Œ?” */
			StringBuilder sb_temp = new StringBuilder("");
			/* ?Œ¨?„´?´ ëª‡ë²ˆ ë°˜ë³µ?¬?Š”ì§? ?? ì¹´ìš´?„° */
			int count = 0;
			while (m.find()) {
				/* sb_temp?? ë¹„êµ?•   ?Š¤?Š¸ë§ë¹Œ?” */
				StringBuilder sb_check = new StringBuilder(m.group());
				/* ?´? „ê³? ?´?›„ ë¹„êµ ê°™ìœ¼ë©? ì¹´ìš´?„° ì¦ê? */
				if (sb_temp.toString().equals(sb_check.toString())) {
					count++;
				} else {
					/* ì¹´ìš´?„°ê°? 0?˜?Š” 1?´ ?•„?‹ˆ?¼ë©? ?‹µ?•ˆë¬¸ì?—´?— ?ˆ«? ì¶”ê?, ?ˆ«?ê°? ?Œ¨?„´ ?•?— ???•¼?•˜ë¯?ë¡? ì§?? •?œ ?œ„ì¹˜ì— ?ˆ«? ?‚½?… */
					if (count != 1 && count != 0) {
						sb_all.insert(sb_all.length() - i, count);
					}
					/* ?Œ¨?„´?´ ë°˜ë³µ?˜ì§? ?•Š?œ¼ë©? ì¹´ìš´?„°?Š” 1, ?‹µ?•ˆë¬¸ì?—´?— ?Œ¨?„´ì¶”ê?, sb_tempë¥? ë¹„ì? */
					count = 1;
					sb_all.append(sb_check);
					sb_temp.delete(0, sb_temp.length());
				}
				System.out.println(sb_check);
				/* ?‹¤?Œ ë£¨í”„?—?„œ ë¹„êµë¥? ?œ„?•´ sb_checkë¥? sb_temp?— ë³µì‚¬?•¨*/
				sb_temp = new StringBuilder(sb_check); 
			}
			/* ë£¨í”„ê°? ??‚˜ê³? ë§ˆì?ë§? ?—°?‚°, matcher?— ?”?—¬ë¬¸ì?—´?´ ë¬´ì‹œ?˜?Š” ?Š¹?„±?•Œë¬¸ì—*/
			if (count != 1 && count != 0) {
				sb_all.insert(sb_all.length() - i, count);
			}
			/* ë§ˆì?ë§? ?”?—¬ ë¬¸ì?—´?„ substringë¡? ?˜?¼?‚´?„œ ë­ì—¬ì¤? */
			sb_all.append(s.substring(s.length()-s.length()%i));
			/* ë¬¸ì?—´ê¸¸ì´?˜ ìµœì†Œê°’ì„ êµ¬í•¨*/
			min_size = Math.min(min_size, sb_all.length());
			/* ?™•?¸?„ ?œ„?•œ sysout */
			System.out.println(sb_all.toString());
		}
		int answer = min_size;
		return answer;
	}
}
