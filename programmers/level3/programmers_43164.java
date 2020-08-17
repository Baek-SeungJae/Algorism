package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;

public class programmers_43164 {
	static String answer = "ZZZZ";

	public static void main(String[] args) {
		
		String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
		String[] answer = solution(tickets);
		for(int i=0; i< answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
		System.out.println();
		
		String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		String[] answer2 = solution(tickets2);
		for(int i=0; i< answer2.length; i++) {
			System.out.print(answer2[i]+" ");
		}
		System.out.println();
		
		String[][] tickets3 = {{"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A"}};
		String[] answer3 = solution(tickets3);
		for(int i=0; i< answer3.length; i++) {
			System.out.print(answer3[i]+" ");
		}
		System.out.println();
		
	}

	public static String[] solution(String[][] tickets) {
		
		HashMap<String,ArrayList<String>> ticketsMap = new HashMap<>();
		for(int i=0; i< tickets.length; i++) {
			if(!ticketsMap.containsKey(tickets[i][0])) {
				ticketsMap.put(tickets[i][0], new ArrayList<>());
				ticketsMap.get(tickets[i][0]).add(tickets[i][1]);
			}else {
				ticketsMap.get(tickets[i][0]).add(tickets[i][1]);
			}
		}
		String current = "ICN";
		System.out.println(ticketsMap);
		dfs(0, tickets.length, current, "", ticketsMap);
        return answer.split(",");
    }
	public static void dfs(int idx, int end, String current, String result, HashMap<String,ArrayList<String>> ticketsMap) {

		result = result + current + ",";
		if(idx==end) {
			if(result.compareTo(answer)<0) {
				answer = result;
			}
			return;
		}
		if(!ticketsMap.containsKey(current)) {
			return;
		}
		
		for(int i=0; i<ticketsMap.get(current).size(); i++) {
			HashMap<String,ArrayList<String>> ticketsMapCopy = ticketsMapCopy(ticketsMap);
			String temp = ticketsMap.get(current).get(i);
			ticketsMapCopy.get(current).remove(temp);
			dfs(idx+1, end, temp, result, ticketsMapCopy);
		}
	}
	public static HashMap<String,ArrayList<String>> ticketsMapCopy (HashMap<String,ArrayList<String>> ticketsMap){
		HashMap<String,ArrayList<String>> ticketsMapCopy = (HashMap<String, ArrayList<String>>) ticketsMap.clone();
		for (String key : ticketsMap.keySet()) {
			ticketsMapCopy.put(key, (ArrayList<String>) ticketsMap.get(key).clone());
		}
		return ticketsMapCopy;
	}

}
