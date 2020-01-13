package daily;

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
