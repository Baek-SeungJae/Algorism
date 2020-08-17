package programmers.level1;

import java.util.ArrayList;
import java.util.TreeMap;

public class Programmers_12915 {
	public static void main(String[] args) {
		String[] strings = new String[] {"sun", "bed", "car"};
		int n = 1;
		solution(strings, n);

	}

	public static String[] solution(String[] strings, int n) {
		TreeMap<Character,ArrayList<String>> tm = new TreeMap<>();
		
		for(int i=0; i<strings.length; i++) {
			if(tm.get(strings[i].charAt(n))==null) {
				tm.put((strings[i].charAt(n)),new ArrayList<>());
				tm.get(strings[i].charAt(n)).add(strings[i]);
			} else {
				tm.get(strings[i].charAt(n)).add(strings[i]);
			}
		}
		for (Character ch : tm.keySet()) {
			tm.get(ch).sort(null);
		}
		
		ArrayList<String> arr = new ArrayList<>();
		for (Character ch : tm.keySet()) {
			for(int i=0; i<tm.get(ch).size(); i++) {
				arr.add(tm.get(ch).get(i));
			}
		}
		
		String[] answer = new String[arr.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = arr.get(i);
		}
        return answer;
        
    }
}