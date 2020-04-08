package line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class exam04 {
	public static void main(String[] args) {
		String[][] snapshots = { { "ACCOUNT1", "100" }, { "ACCOUNT2", "150" } };
		String[][] transactions = { { "1", "SAVE", "ACCOUNT2", "100" }, { "2", "WITHDRAW", "ACCOUNT1", "50" },
				{ "1", "SAVE", "ACCOUNT2", "100" }, { "4", "SAVE", "ACCOUNT3", "500" },
				{ "3", "WITHDRAW", "ACCOUNT2", "30" } };
		solution(snapshots, transactions);
	}

	public static String[][] solution(String[][] snapshots, String[][] transactions) {
		HashMap<String, String> snmap = new HashMap<String, String>();
		HashMap<String, String[]> trmap = new HashMap<String, String[]>();
		for (int i = 0; i < snapshots.length; i++) {
			snmap.put(snapshots[i][0], snapshots[i][1]);
		}
		for (int i = 0; i < transactions.length; i++) {
			trmap.put(transactions[i][0], transactions[i]);
		}

		for (int i = 1; i <= trmap.size(); i++) {
			if (snmap.containsKey(trmap.get(i + "")[2])) {
				if (trmap.get(i + "")[1].equals("SAVE")) {
					snmap.replace(trmap.get(i + "")[2], Integer.parseInt(snmap.get(trmap.get(i + "")[2]))
							+ Integer.parseInt(trmap.get(i + "")[3]) + "");
				} else {
					snmap.replace(trmap.get(i + "")[2], Integer.parseInt(snmap.get(trmap.get(i + "")[2]))
							- Integer.parseInt(trmap.get(i + "")[3]) + "");
				}

			} else {
				if (trmap.get(i + "")[1].equals("SAVE")) {
					snmap.put(trmap.get(i + "")[2], Integer.parseInt(trmap.get(i + "")[3]) + "");
				}
			}

		}
		ArrayList<String> arr = new ArrayList<String>(snmap.keySet());
		arr.sort(null);
		String[][] temp = new String[arr.size()][2];
		for (int i = 0; i < arr.size(); i++) {
			temp[i][0] = arr.get(i);
			temp[i][1] = snmap.get(arr.get(i));
		}
		String[][] answer = temp;
		print(answer);
		return answer;
	}

	public static void print(String[][] strarr) {
		for (int i = 0; i < strarr.length; i++) {
			for (int j = 0; j < strarr[i].length; j++) {
				System.out.print(strarr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
