package daily;
/*
 주어진 string 에 모든 단어를 거꾸로 하시오.
Reverse all the words in the given string.

예제)
Input: “abc 123 apple”
Output: “cba 321 elppa” 
 */
public class O20191215 {

	public static void main(String[] args) {
		String input = "abc 123 apple";
		String[] split= input.split(" ");
		String temp="";
		for(int i=0; i<split.length;i++) {
			char[] chararr= split[i].toCharArray();
			int charlen= split[i].length();
			for(int j=0; j<charlen; j++) {
				temp+=chararr[charlen-1-j];
			}
			split[i] = temp;
			temp="";
		}
		for(int i=0; i<split.length;i++) {
			if(i!=split.length-1)
			System.out.print(split[i]+" ");
			else
			System.out.print(split[i]);
		}
	}
}
