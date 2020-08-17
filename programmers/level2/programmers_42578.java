package programmers.level2;

import java.util.HashMap;

public class programmers_42578 {

	public static void main(String[] args) {
		String[][] clothes = new String[][] { { "yellow_hat", " headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", " headgear" } };
		System.out.println(solution(clothes));
	}

	public static int solution(String[][] clothes) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		for(int i=0; i<clothes.length; i++) {
			if(map.containsKey(clothes[i][1]))
				map.replace(clothes[i][1], map.get(clothes[i][1])+1);
			else
				map.put(clothes[i][1],1);
		}
		int answer = 1;
		for (String string : map.keySet()) {
			answer *= (map.get(string)+1);
		}
		
        
        return answer-1;
    }
}
