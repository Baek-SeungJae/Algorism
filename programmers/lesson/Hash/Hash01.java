package programmers.lesson.Hash;

import java.util.HashMap;

public class Hash01 {
	public static void main(String[] args) {
		String[] participant = new String[] { "mislav", "stanko", "mislav", "ana" };
		String[] completion = new String[] { "stanko", "ana", "mislav" };
		solution(participant, completion);
	}

	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < participant.length; i++) {
			if (map.containsKey(participant[i]))
				map.replace(participant[i], map.get(participant[i]) + 1);
			else
				map.put(participant[i], 1);
		}
		for (int i = 0; i < completion.length; i++) {
			if(map.get(completion[i])==1)
				map.remove(completion[i]);
			else
				map.replace(completion[i], map.get(completion[i]) - 1);
		}
		
		//System.out.println(map.keySet().toArray()[0]);
		return (String) map.keySet().toArray()[0];
	}
}
