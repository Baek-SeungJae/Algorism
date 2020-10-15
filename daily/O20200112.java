package daily;
/*
길이가 같은 두 문자열(string) A 와 B가 주어지면, A 가 B 로 1:1 암호화 가능한지 찾으시오.
Given two strings of equal length, check if two strings can be encrypted 1 to 1.

예제)
Input: “EGG”, “FOO”
Output: True // E->F, G->O
Input: “ABBCD”, “APPLE”
Output: True // A->A, B->P, C->L, D->E
Input: “AAB”, “FOO”
Output: False
*/

public class O20200112 {
	public static void main(String[] args) {
		String input1 = "AAB";
		String input2 = "FOO";
		int inputsize = input1.length();
		int count=0;
		char[] chararr1 = input1.toCharArray();
		char[] chararr2 = input2.toCharArray();
		char[] check= new char[26];
		for(int i=0; i<inputsize; i++) {
			if(check[chararr1[i]-65]==0||check[chararr1[i]-65]==chararr2[i]) {
				check[chararr1[i]-65]=chararr2[i];
				count++;
			}
		}
		if(inputsize==count)
			System.out.println("True");
		else
			System.out.println("False");
	}
}
