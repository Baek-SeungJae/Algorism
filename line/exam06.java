package line;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class exam06 {

	public static void main(String[] args) {
		String[] directory = { "/" };
		String[] command = { "mkdir /a", "mkdir /a/b", "mkdir /a/b/c", "cp /a/b /", "rm /a/b/c"};
		solution(directory, command);
	}

	public static String[] solution(String[] directory, String[] command) {
		HashSet<String> set = new HashSet<String>();
		Pattern pattern = null;
		Matcher m = null;
		for (int i = 0; i < directory.length; i++) {
			set.add(directory[i]);
		}
		for (int i = 0; i < command.length; i++) {
			String[] temp = command[i].split(" ");

			if (temp[0].equals("mkdir")) {
				set.add(temp[1]);
			}
			if (temp[0].equals("cp")) {
				String patternStr = "^" + temp[1] + ".*";
				pattern = Pattern.compile(patternStr);
				ArrayList<String> arraylisttemp = new ArrayList<String>();
				String leaf = "";
				for (String string : set) {
					m = pattern.matcher(string);
					while (m.find()) {
						String tm = m.group();
						if(leaf.equals("")) {
							leaf = tm.substring(tm.lastIndexOf("/"),tm.length());
						}
						tm = tm.substring(tm.indexOf(leaf), tm.length());
						if (temp[2].equals("/"))
							arraylisttemp.add(tm);
						else
							arraylisttemp.add(temp[2] + tm);
					}
				}
				set.addAll(arraylisttemp);
			}
			if (temp[0].equals("rm")) {
				String patternStr = "^" + temp[1] + ".*";
				pattern = Pattern.compile(patternStr);
				ArrayList<String> arraylisttemp = new ArrayList<String>(set);
				for (int j = 0; j < arraylisttemp.size(); j++) {
					m = pattern.matcher(arraylisttemp.get(j));
					while (m.find()) {
						arraylisttemp.remove(m.group());
						j--;
					}
				}
				set.clear();
				set.addAll(arraylisttemp);
			}

		}
		ArrayList<String> arr = new ArrayList<String>(set);
		arr.sort(null);
		System.out.println(arr);
		String[] answer = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}
}
