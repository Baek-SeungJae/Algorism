package daily;

/*
臾몄옄�뿴 諛곗뿴(string array)�씠 二쇱뼱吏�硫�, �젣�씪 湲� 怨듯넻�맂 �젒�몢�궗(prefix)�쓽 湲몄씠瑜� 李얠쑝�떆�삤.
Given an array of strings, find the longest common prefix of all strings.
�삁�젣)
Input: [�쏿pple��, �쏿pps��, �쏿pe��]
Output: 2 // �쏿p��

Input: [�쐆awaii��, �쐆appy��]
Output: 2 // �쐆a��

Input: [�쐂og��, �쐂ogs��, �쐂oge��]
Output: 3 // �쐂og��
 */
public class O20200202 {
   public static void main(String[] args) {

      String[] input = { "apple", "apps", "ape" };
      char temp;
      int inputsize = input.length;
      int count = 0;
      for (int j = 0; j < input[0].length(); j++) {
         temp = input[0].charAt(j);
         for (int i = 1; i < inputsize; i++) {
            if(temp==input[i].charAt(j)) {
               
            }
            else {
               System.out.println(count);
               return;
            }
         }
         count++;
      }
      System.out.println(count);
   }
}