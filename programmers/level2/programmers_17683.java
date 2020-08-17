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
		/* Map?��?�� ArrayList�? ?��?��?�� 구조 */
		Map<Integer, ArrayList<String>> map = new TreeMap<>(Comparator.reverseOrder());
		
		/* ?��?��?��간을 TreeMap 구조�? ?��?��?�� ?��?��?��간이 �? ?��?��??�? ?��?��?���? ?�� */
		for (int i = 0; i < musicinfos.length; i++) {
			
			/* musicinfos�? 분할 */
			String[] music = musicinfos[i].split(",");
			/* #붙�? ?��?�� ?��문자�? ??�? */
			String lyric = music[3].replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f")
					.replaceAll("G#", "g").replaceAll("A#", "a").replaceAll("B#", "b").replaceAll("#E", "e");
			
			/* ?��간경과�?? 계산?��주는 ?��?��, int�? 리턴*/
			int time = time(music[0], music[1]);
			
			/* ?��간경과에 맞춰?�� ?��?��?��간과 �??���? 반복?��?���? StringBuilder?�� ???��?���? map?��?��?��?�� ArrayList?�� ???�� */
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
		/* answer?�� ?��?��?��?�� None */
		String answer = "(None)";
		/* map?��  ?��?��?��면서 �??���? ?��?��?��?�� ?��?���? 리턴, TreeMap?���?�? ?��간순?���? ?��?��?��?��?���?, ArrayList?���?�? 먼�??��?��?�� 곡정보�?? 반환 */
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

	/* ?��?��?�� �? 분동?�� ?��?��?��?��?���? */
	public static int time(String start, String end) {
		int hour = Integer.parseInt(end.split(":")[0]) - Integer.parseInt(start.split(":")[0]);
		int minute = Integer.parseInt(end.split(":")[1]) - Integer.parseInt(start.split(":")[1]);
		hour = (hour + 24) % 24;
		return hour * 60 + minute;
	}
}
