package line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class exam05 {

	public static void main(String[] args) {
		String[][] dataSource = { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" },
				{ "doc3", "t1", "t6", "t7" }, { "doc4", "t1", "t2", "t4" }, { "doc5", "t6", "t100", "t8" } };
		String[] tags = { "t1", "t6", "t7" };
		String[] answer = solution(dataSource, tags);
		for(int i=0; i<answer.length; i++)
			System.out.println(answer[i]);
	}

	public static String[] solution(String[][] dataSource, String[] tags) {
		
		ArrayList<String> arrlist = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0; i<dataSource.length; i++) {
			HashSet<String> set = new HashSet<String>();
			int count = 0;
			for(int j=1; j<dataSource[i].length; j++) {
				set.add(dataSource[i][j]);
			}
			for(int j=0; j<tags.length;j++) {
				if(set.contains(tags[j])) {
					count++;
				}
			}
			arrlist.add(count+","+dataSource[i][0]);
		}
		arrlist.sort(Collections.reverseOrder());
		
		int size =10;
		if(size>arrlist.size())
			size = arrlist.size();
		int before = Integer.parseInt(arrlist.get(0).split(",")[0]);
		ArrayList<String> temp = new ArrayList<String>();
		for(int i=0; i<size; i++) {
			int after = Integer.parseInt(arrlist.get(i).split(",")[0]);
			if(before==after) {
				temp.add(arrlist.get(i));
			}
			else {
				result.addAll(temp);
				temp.clear();
				temp.add(arrlist.get(i));
			}
			before = after;
			temp.sort(null);
		}
		arrlist.clear();
		for(int i=0; i<result.size(); i++) {
			if(result.get(i).split(",")[0].equals("0")) {
				
			}else {
				arrlist.add(result.get(i).split(",")[1]);
			}
		}
		String[] solution = arrlist.toArray(new String[]{});
		return solution;
	}
}
