package daily;

import java.util.LinkedList;

public class O20200913 {
	public static void main(String[] args) {
		String input = "ABC";
		solution(input);
	}

	public static void solution(String input) {
		char[] newChar = input.toCharArray();
        LinkedList<Integer> perArr = new LinkedList<Integer>(); 
        int[] perCheck = new int[newChar.length];
		permutation(newChar.length, newChar.length, perArr, perCheck,newChar);
	}

	private static void permutation(int n, int r, LinkedList<Integer> perArr, int[] perCheck, char[] newChar) {
        if(perArr.size() == r){
            for(int i : perArr){
                System.out.print(newChar[i]);
            }
            System.out.println();
            return;
        }
         
        for(int i=0; i<n; i++){
            if(perCheck[i] == 0){
                perArr.add(i);
                perCheck[i] = 1;
                permutation(n, r, perArr, perCheck, newChar);
                perCheck[i] = 0;
                perArr.removeLast();
            }
        }
    }
}