package line;

public class exam01 {
	public static void main(String[] args) {
		//String input = "[if] <else> (Count of eggs is 4.) {Buy milk.}";
		String input = "[i(f]<[)>] (Count of eggs is 4.) {Buy milk.}";
		int check1 = 0;
		int check2 = 0;
		int check3 = 0;
		int check4 = 0;
		int count = 0;
		char[] inputarr = input.toCharArray();
		for(int i=0; i<inputarr.length; i++) {
			if(inputarr[i]=='[') {
				check1 ++;
			}
			if(inputarr[i]==']') {
				check1 --;
				count++;
			}
			if(check1<0) {
				count = -1;
				break;
			}
			if(inputarr[i]=='(') {
				check2 ++;
			}
			if(inputarr[i]==')') {
				check2 --;
				count++;
			}
			if(check2<0) {
				count = -1;
				break;
			}
			if(inputarr[i]=='{') {
				check3 ++;
			}
			if(inputarr[i]=='}') {
				check3 --;
				count++;
			}
			if(check3<0) {
				count = -1;
				break;
			}
			if(inputarr[i]=='<') {
				check4 ++;
			}
			if(inputarr[i]=='>') {
				check4 --;
				count++;
			}
			if(check4<0) {
				count = -1;
				break;
			}
		}
		if(check1==0&&check2==0&&check3==0&&check4==0) {
		}
		else {
			count = -1;
		}
			System.out.println(count);
	}
}
