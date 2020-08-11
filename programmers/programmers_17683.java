package programmers;

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
		/* Map안에 ArrayList를 사용한 구조 */
		Map<Integer, ArrayList<String>> map = new TreeMap<>(Comparator.reverseOrder());
		
		/* 재생시간을 TreeMap 구조로 잡아서 재생시간이 긴 순서대로 정렬되게 함 */
		for (int i = 0; i < musicinfos.length; i++) {
			
			/* musicinfos를 분할 */
			String[] music = musicinfos[i].split(",");
			/* #붙은 음을 소문자로 대체 */
			String lyric = music[3].replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f")
					.replaceAll("G#", "g").replaceAll("A#", "a").replaceAll("B#", "b").replaceAll("#E", "e");
			
			/* 시간경과를 계산해주는 함수, int로 리턴*/
			int time = time(music[0], music[1]);
			
			/* 시간경과에 맞춰서 재생시간과 가사를 반복적으로 StringBuilder에 저장하고 map안에있는 ArrayList에 저장 */
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
		/* answer의 디폴트는 None */
		String answer = "(None)";
		/* map을  순회하면서 가사가 포함되어 있으면 리턴, TreeMap이므로 시간순으로 정렬되어있고, ArrayList이므로 먼저입력된 곡정보를 반환 */
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

	/* 음악이 몇 분동안 재생되었는지 */
	public static int time(String start, String end) {
		int hour = Integer.parseInt(end.split(":")[0]) - Integer.parseInt(start.split(":")[0]);
		int minute = Integer.parseInt(end.split(":")[1]) - Integer.parseInt(start.split(":")[1]);
		hour = (hour + 24) % 24;
		return hour * 60 + minute;
	}
}
