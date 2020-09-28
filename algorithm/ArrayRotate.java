/*
 * 주요내용 : N*M배열 회전, 대칭이동
 *	작성자 : 백승재 
 *    출처 : 완전 자체작성 
 */

package algorithm;

public class ArrayRotate {

	public static void main(String[] args) {
		int[][] array = {{1,1},{1,1},{0,0},{0,0}};
		/* 시계방향으로 회전하는지 확인*/
		print(array);
		array = rotate(array);
		print(array);
		array = rotate(array);
		print(array);
		array = rotate(array);
		print(array);
		
		/* 반시계방향으로 회전하는지 확인 */
		array= reverse_rotate(array);
		print(array);
		array= reverse_rotate(array);
		print(array);
		array= reverse_rotate(array);
		print(array);
		
	}
	/* 배열 출력 */
	public static void print(int[][] array) {
		for(int i=0; i<array.length;i++) {
			for(int j=0; j< array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	/* 시계방향으로 회전 */
	public static int[][] rotate(int[][] array) {
		int[][] rotated = new int[array[0].length][array.length];
		for (int i = 0; i < rotated.length; i++) {
			for (int j = 0; j < rotated[0].length; j++) {
				rotated[i][j] = array[rotated[0].length - 1 - j][i];
			}
		}
		return rotated;
	}
	/* 반시계방향으로 회전 */
	public static int[][] reverse_rotate(int[][] array){
		int [][] rotated = new int[array[0].length][array.length];
		
		for(int i=0; i<rotated.length;i++) {
			for(int j=0; j< rotated[0].length; j++) {
				rotated[i][j] = array[j][rotated.length-1-i];
			}
		}
		return rotated;
	}
	
	/* 수직 뒤집기 */
	public static int[][] vertical_mirror(int[][] array){
		int [][] rotated = new int[array.length][array[0].length];
		
		for(int i=0; i<rotated.length;i++) {
			for(int j=0; j< rotated[0].length; j++) {
				rotated[i][j] = array[rotated.length-1-i][j];
			}
		}
		return rotated;
	}
	/* 수평 뒤집기 */
	public static int[][] horizontal_mirror(int[][] array){
		int [][] rotated = new int[array.length][array[0].length];
		
		for(int i=0; i<rotated.length;i++) {
			for(int j=0; j< rotated[0].length; j++) {
				rotated[i][j] = array[i][rotated[0].length-1-j];
			}
		}
		return rotated;
	}
}
