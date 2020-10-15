package daily;
/*
String이 주어지면, 중복된 char가 없는 가장 긴 서브스트링 (substring)의 길이를 찾으시오. 
Given a string, find the longest substring that does not have duplicate characters.

예제)
Input: “aabcbcbc”
Output: 3 // “abc”
Input: “aaaaaaaa”
Output: 1 // “a”
Input: “abbbcedd”
Output: 4 // “bced” 
 */
import java.util.HashSet;
public class O20200105 {
	public static void main(String[] args) {
		int max=0;
		int temp=0;
		String input = "abbbcedd";
		char[] chararr = input.toCharArray();
		int inputsize= input.length();
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0; i<inputsize; i++)
		{
			if(set.contains(chararr[i]))
			{
				char t = chararr[i];
				if(temp>max)
					max=temp;
				temp=1;
				set.clear();
				set.add(t);
			}
			else {
				set.add(chararr[i]);
				temp++;
			}
		}
		System.out.println(max);
	}
}
