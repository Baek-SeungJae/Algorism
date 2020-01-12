package programmers;

public class Programmers_17681 {
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = new int[] { 9, 20, 28, 18, 11 };
		int[] arr2 = new int[] { 30, 1, 21, 17, 28 };
		solution(n,arr1,arr2);
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] str1 = new String[n];
		String[] str2 = new String[n];
		String[] answer = new String[n];
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<str1.length; i++) {
			str1[i] = dec2bin(arr1[i],n);
		}
		for(int i=0; i<str2.length; i++) {
			str2[i] = dec2bin(arr2[i],n);
		}
		for(int i=0; i<str2.length; i++) {
			System.out.println(str1[i]);
		}
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				if(str1[i].charAt(j)=='1'||str2[i].charAt(j)=='1') {
					sb.append("#");
				}
				else {
					sb.append(" ");
				}
				
			}
			answer[i] = sb.toString();
			System.out.println(answer[i]);
			sb = new StringBuffer("");
		}
		return answer;
	}
	public static String dec2bin(int a,int n) {
		
		StringBuffer sb = new StringBuffer("");
		
		while(true) {
			
			if(a%2==1) {
				sb.append("1");
			}
			else {
				sb.append("0");
			}
			if((a==0||a==1))
				break;
			a=a/2;
		}
		while(sb.length()!=n) {
			sb.append("0");
		}
		sb.reverse();
		return sb.toString();
	}
}