package daily;
/*
 
정수 배열과 타겟 숫자가 주어지면, 합이 타겟값이 되는 두 원소의 인덱스를 찾으시오.
단, 시간복잡도 O(n) 여야 합니다.
Given an array of integers and a target integer, find two indexes of the array element that sums to the target number.

예제)
Input: [2, 5, 6, 1, 10], 타겟 8
Output: [0, 2] // 배열[0] + 배열[2] = 8
 */
import java.util.ArrayList;

public class O20191201 {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(2);
		array.add(5);
		array.add(6);
		array.add(1);
		array.add(10);
		int target=16;
		find(array, target);
	}
	
	public static void find(ArrayList<Integer> array, int target) {
		int a=0;
		int b=0;
		for(int i=0; i<array.size();i++) {
			a=i;
			b=array.indexOf(target-array.get(i));
			if(b!=-1)
				break;
		}
		if(b!=-1)
			System.out.println(a+","+b);
		else
			System.out.println("�������");
	}
}

