package daily;
/*
Given an integer N, find the number of possible balanced parentheses with N opening and closing brackets.

����)
Input: 1
Output: ["()"]

Input: 2
Output: ["(())", "()()"]

Input: 3
Output: ["((()))", "(()())", "()(())", "(())()", "()()()"]
 */
import java.util.ArrayList;
import java.util.List;

public class A20191117 {

	public static void main(String[] args) {
		List<String> ans = new ArrayList<String>();
		solution(ans, "", 0, 0, 3);
		for (String str : ans) {
			System.out.println(str);
		}
	}

	public static void solution(List<String> ans, String cur, int open, int close, int n) {
		if (cur.length() == n * 2) {
			ans.add(cur.toString());
			return;
		}
		if (open < n) {
			solution(ans, cur + "(", open + 1, close, n);
		}
		if (close < open) {
			solution(ans, cur + ")", open, close + 1, n);
		}
	}
}
