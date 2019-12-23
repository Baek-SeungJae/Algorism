package daily;
/*
 안녕하세요, 매일프로그래밍 이번주 문제입니다.
 
정수 n이 주어지면, n개의 여는 괄호 "("와 n개의 닫는 괄호 ")"로 만들 수 있는 괄호 조합을 모두 구하시오. (시간 복잡도 제한 없습니다).

Given an integer N, find the number of possible balanced parentheses with N opening and closing brackets.

예제)
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
		solution(ans, "", 0, 0, 4);
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
