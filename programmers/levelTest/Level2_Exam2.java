package programmers.levelTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Level2_Exam2 {
	public static void main(String[] args) {
		String input = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

		int[] print = solution(input);
		for (int i = 0; i < print.length; i++) {
			System.out.print(print[i] + " ");
		}
	}

	public static int[] solution(String s) {
		String[] strtemp = s.split("},");
		int[] arrsize = new int[strtemp.length];
		
		String str[];
		ArrayList<ArrayList<Integer>> arrlist = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int i=0; i<strtemp.length; i++){
			str = strtemp[i].split(",");
			for(int j=0; j<str.length; j++) {
				Pattern p = Pattern.compile("[\\d]{1,}");
				Matcher m= p.matcher(str[j]);
				while(m.find()) {
					str[j]=m.group();
				}
				try {
					temp.add(Integer.parseInt(str[j]));
				} catch (NumberFormatException e) {
				}
			}
			arrlist.add(new ArrayList<Integer>(temp));
			temp.clear();
		}
		
		for(int i=0; i<arrlist.size();i++) {
			arrsize[arrlist.get(i).size()-1]=i;
		}
		
		for(int i=0; i<arrsize.length; i++) {
			for(int j=0; j< arrlist.get(arrsize[i]).size(); j++) {
				if(!temp.contains(arrlist.get(arrsize[i]).get(j)))
					temp.add(arrlist.get(arrsize[i]).get(j));
			}
		}
		
		int[] answer = new int[strtemp.length];
		for(int i=0; i<strtemp.length;i++) {
			answer[i] = temp.get(i);
		}
        return answer;
    }
}
