package programmers.level3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class programmers_42579 {

	public static void main(String[] args) {
		
		String[] genres = new String[] {"c","a","a","b"};
		int[] plays = new int[] {1,3,3,3};
		
		int[] sol = solution(genres, plays);
		for(int i=0; i<sol.length;i++) {
			System.out.println(sol[i]);
		}
	}

	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String,Integer> playcount = new HashMap<String,Integer>();
		HashMap<String,String> rank = new HashMap<String,String>();
		for(int i=0; i<genres.length;i++) {
			if(playcount.containsKey(genres[i])) {
				playcount.replace(genres[i], playcount.get(genres[i])+plays[i]);
				int temp=plays[i];
				int first=0;
				
				int second=0;
				try {
					first = Integer.parseInt((rank.get(genres[i]).split(",")[1]));
					second = Integer.parseInt((rank.get(genres[i]).split(",")[3]));
				}
				catch(ArrayIndexOutOfBoundsException e) {
				}
				if(temp>first) {
					second = first;
					first = temp;
					rank.put(genres[i],i+","+temp+","+rank.get(genres[i]).split(",")[0]+","+second);
				}else if(temp>second) {
					second = temp;
					rank.put(genres[i],rank.get(genres[i]).split(",")[0]+","+first+","+i+","+second);
				}
				
			} else {
				playcount.put(genres[i], plays[i]);
				rank.put(genres[i],i+","+plays[i]);
			}
		}
		
	
		Collection<Integer> list = playcount.values();
		ArrayList<Integer> l = new ArrayList<>();
		l.addAll(list);
		l.sort(Comparator.reverseOrder());
		
		HashMap<Integer,String> temp = new HashMap<Integer,String>(){};
		Set<String> set = playcount.keySet();
		for (String string : set) {
			temp.put(playcount.get(string),string);
		}
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<l.size();i++) {
			sb.append(rank.get(temp.get(l.get(i))).split(",")[0]);
			sb.append(",");
			try {
			sb.append(rank.get(temp.get(l.get(i))).split(",")[2]);
			sb.append(",");
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			
		}
		
        String[] ans = sb.toString().split(",");
        int[] answer = new int[ans.length];
        for(int i=0; i<ans.length; i++) {
        	answer[i] = Integer.parseInt(ans[i]);
        	//System.out.println(answer[i]);
        }
        return answer;
    }
}
