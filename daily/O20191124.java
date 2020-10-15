package daily;
/*
주어진 정수가 펠린드롭인지 확인하는 문제

Given an integer, check if it is a palindrome.

����)
Input: 12345 
Output: False

Input: -101 
Output: False

Input: 11111 
Output: True

Input: 12421 
Output: True
*/
public class O20191124 {
	public static void main(String[] args) {
		int input = 1221;
		System.out.println(palindrome(input));
		
	}
	
	public static boolean palindrome(int input) {
		int temp = input;
		int count=1;
		while((temp/10)>0) {
			temp=temp/10;
			count++;
		}
		int[] array = new int[count];
		temp = input;
		for(int i=0; i<count; i++)
		{
			array[i] = temp%10;
			temp = temp/10;
		}
		for(int i=0; i<count/2; i++)
		{
			if(array[i]==array[count-1-i]) {
			}
			else {
				return false;
			}
		}
		return true;
	}

}
