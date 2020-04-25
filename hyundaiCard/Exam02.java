package hyundaiCard;

import java.util.HashMap;

public class Exam02 {
	public static void main(String[] args) {

		String[] ip_addrs = new String[] {"5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5", "155.123.124.111", "10.16.125.0", "10.16.125.0"};
		String[] langs = new String[] { "Java", "C++", "Python3", "C#", "Java", "C", "Python3", "JavaScript" };
		int[] scores = new int[] { 294, 197, 373, 45, 294, 62, 373, 373 };
		solution(ip_addrs, langs, scores);
	}

	public static int solution(String[] ip_addrs, String[] langs, int[] scores) {

		for (int i = 0; i < langs.length; i++) {
			if (langs[i].charAt(0) == 'C')
				langs[i] = "C";
		}
		HashMap<String,String> sol = new HashMap<>();
		sol.putAll(t3(ip_addrs, langs, scores));
		sol.putAll(t2(ip_addrs, langs));
		sol.putAll(t1(ip_addrs));
		int answer = ip_addrs.length-sol.size();
		System.out.println(answer);
		return answer;
	}

	public static HashMap<String, String> t1(String[] ip_addrs) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < ip_addrs.length; i++) {
			if (!map.containsKey(ip_addrs[i])) {
				map.put(ip_addrs[i], 1);
			} else {
				map.put(ip_addrs[i], map.get(ip_addrs[i]) + 1);
			}
		}
		HashMap<String, String> cheat = new HashMap<String, String>();
		for (int i = 0; i < ip_addrs.length; i++) {
			if (map.get(ip_addrs[i]) >= 4) {
				cheat.put(i + "", ip_addrs[i]);
			}
		}
		return cheat;
	}

	public static HashMap<String, String> t2(String[] ip_addrs, String[] langs) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < ip_addrs.length; i++) {
			if (!map.containsKey(ip_addrs[i] + "," + langs[i])) {
				map.put(ip_addrs[i] + "," + langs[i], 1);
			} else {
				map.put(ip_addrs[i] + "," + langs[i], map.get(ip_addrs[i] + "," + langs[i]) + 1);
			}
		}
		HashMap<String, String> cheat = new HashMap<String, String>();
		for (int i = 0; i < ip_addrs.length; i++) {

			if (map.containsKey(ip_addrs[i] + ",Java")) {
				if (map.get(ip_addrs[i] + ",Java") == 3) {
					if (map.getOrDefault(ip_addrs[i] + "," + "Java", 0) == 0
							&& map.getOrDefault(ip_addrs[i] + "," + "JavaScript", 0) == 0
							&& map.getOrDefault(ip_addrs[i] + "," + "C", 0) == 0) {
						cheat.put(i + "", ip_addrs[i]);
					}
				}
			}
			if (map.containsKey(ip_addrs[i] + ",JavaScript")) {
				if (map.get(ip_addrs[i] + ",JavaScript") == 3) {
					if (map.getOrDefault(ip_addrs[i] + "," + "Java", 0) == 0
							&& map.getOrDefault(ip_addrs[i] + "," + "C", 0) == 0
							&& map.getOrDefault(ip_addrs[i] + "," + "Python3", 0) == 0) {
						cheat.put(i + "", ip_addrs[i]);
					}
				}
			}
			if (map.containsKey(ip_addrs[i] + ",Python3")) {
				if (map.get(ip_addrs[i] + ",Python3") == 3) {
					if (map.getOrDefault(ip_addrs[i] + "," + "Java", 0) == 0
							&& map.getOrDefault(ip_addrs[i] + "," + "JavaScript", 0) == 0
							&& map.getOrDefault(ip_addrs[i] + "," + "C", 0) == 0) {
						cheat.put(i + "", ip_addrs[i]);
					}
				}
			}
			if (map.containsKey(ip_addrs[i] + ",C")) {
				if (map.get(ip_addrs[i] + ",C") == 3) {
					if (map.getOrDefault(ip_addrs[i] + "," + "Java", 0) == 0
							&& map.getOrDefault(ip_addrs[i] + "," + "JavaScript", 0) == 0
							&& map.getOrDefault(ip_addrs[i] + "," + "Python3", 0) == 0) {
						cheat.put(i + "", ip_addrs[i]);
					}
				}
			}

		}
		return cheat;
	}

	public static HashMap<String, String> t3(String[] ip_addrs, String[] langs, int[] scores) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < ip_addrs.length; i++) {
			if (!map.containsKey(ip_addrs[i] + "," + langs[i] + "," + scores[i])) {
				map.put(ip_addrs[i] + "," + langs[i] + "," + scores[i], 1);
			} else {
				map.put(ip_addrs[i] + "," + langs[i] + "," + scores[i],
						map.get(ip_addrs[i] + "," + langs[i] + "," + scores[i]) + 1);
			}
		}
		HashMap<String, String> cheat = new HashMap<String, String>();
		
		for (int i = 0; i < ip_addrs.length; i++) {
			if (map.get(ip_addrs[i] + "," + langs[i] + ","+scores[i]) == 2) {
				cheat.put(i + "", ip_addrs[i]);
			}
		}
		HashMap<String, String> map2 = new HashMap<String, String>();
		HashMap<String, String> cheat2 = new HashMap<String, String>();
		for (int i = 0; i < ip_addrs.length; i++) {
			if (!map2.containsKey(ip_addrs[i])) {
				map2.put(ip_addrs[i],langs[i]);
			} else {
				if(map2.get(ip_addrs[i]).equals(langs[i])) {
					cheat2.put(i + "", ip_addrs[i]);
				}
			}
		}
		for(int i=0; i<cheat.size(); i++) {
			cheat.remove(i,cheat2.getOrDefault(i,""));
		}
		HashMap<String, String> map3 = new HashMap<String, String>();
		HashMap<String, String> cheat3 = new HashMap<String, String>();
		for (int i = 0; i < ip_addrs.length; i++) {
			if (!map3.containsKey(ip_addrs[i]+","+langs[i])) {
				map3.put(ip_addrs[i]+","+langs[i],scores[i]+"");
			} else {
				if(map3.get(ip_addrs[i]+","+langs[i]).equals(scores[i]+"")) {
					cheat3.put(i + "", ip_addrs[i]);
				}
			}
		}
		for(int i=0; i<cheat.size(); i++) {
			cheat.remove(i,cheat3.getOrDefault(i,""));
		}
		
		
		return cheat;
	}

}
