package programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class programmers_17683 {

	public static void main(String[] args) {
		String m = "A#A#";
		String[] musicinfos = new String[] { "00:00,01:02,HAPPY2,A#", "13:00,13:01,HAPPY3,A#" };
		System.out.println(solution(m, musicinfos));
	}

	public static String solution(String m, String[] musicinfos) {
		/* Map?•ˆ?— ArrayListë¥? ?‚¬?š©?•œ êµ¬ì¡° */
		Map<Integer, ArrayList<String>> map = new TreeMap<>(Comparator.reverseOrder());
		
		/* ?¬?ƒ?‹œê°„ì„ TreeMap êµ¬ì¡°ë¡? ?¡?•„?„œ ?¬?ƒ?‹œê°„ì´ ê¸? ?ˆœ?„œ??ë¡? ? •? ¬?˜ê²? ?•¨ */
		for (int i = 0; i < musicinfos.length; i++) {
			
			/* musicinfosë¥? ë¶„í•  */
			String[] music = musicinfos[i].split(",");
			/* #ë¶™ì? ?Œ?„ ?†Œë¬¸ìë¡? ??ì²? */
			String lyric = music[3].replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f")
					.replaceAll("G#", "g").replaceAll("A#", "a").replaceAll("B#", "b").replaceAll("#E", "e");
			
			/* ?‹œê°„ê²½ê³¼ë?? ê³„ì‚°?•´ì£¼ëŠ” ?•¨?ˆ˜, intë¡? ë¦¬í„´*/
			int time = time(music[0], music[1]);
			
			/* ?‹œê°„ê²½ê³¼ì— ë§ì¶°?„œ ?¬?ƒ?‹œê°„ê³¼ ê°??‚¬ë¥? ë°˜ë³µ? ?œ¼ë¡? StringBuilder?— ???¥?•˜ê³? map?•ˆ?—?ˆ?Š” ArrayList?— ???¥ */
			StringBuilder sb = new StringBuilder("");
			for (int j = 0; j <= time; j++) {
				sb.append(lyric.charAt(j % lyric.length()));
			}
			if (map.containsKey(time)) {
				map.get(time).add(music[2] + "," + sb.toString());
			} else {
				map.put(time, new ArrayList<>());
				map.get(time).add(music[2] + "," + sb.toString());
			}
		}
		System.out.println(map);
		/* answer?˜ ?””?´?Š¸?Š” None */
		String answer = "(None)";
		/* map?„  ?ˆœ?šŒ?•˜ë©´ì„œ ê°??‚¬ê°? ?¬?•¨?˜?–´ ?ˆ?œ¼ë©? ë¦¬í„´, TreeMap?´ë¯?ë¡? ?‹œê°„ìˆœ?œ¼ë¡? ? •? ¬?˜?–´?ˆê³?, ArrayList?´ë¯?ë¡? ë¨¼ì??…? ¥?œ ê³¡ì •ë³´ë?? ë°˜í™˜ */
		for (Integer key : map.keySet()) {
			for (int i = 0; i < map.get(key).size(); i++) {
				String changedValue = m.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f")
						.replaceAll("G#", "g").replaceAll("A#", "a").replaceAll("B#", "b").replaceAll("#E", "e");

				if (map.get(key).get(i).split(",")[1].contains(changedValue)) {
					answer = map.get(key).get(i).split(",")[0];
					return answer;
				}
			}
		}
		return answer;
	}

	/* ?Œ?•…?´ ëª? ë¶„ë™?•ˆ ?¬?ƒ?˜?—ˆ?Š”ì§? */
	public static int time(String start, String end) {
		int hour = Integer.parseInt(end.split(":")[0]) - Integer.parseInt(start.split(":")[0]);
		int minute = Integer.parseInt(end.split(":")[1]) - Integer.parseInt(start.split(":")[1]);
		hour = (hour + 24) % 24;
		return hour * 60 + minute;
	}
}
