package daily;

import java.util.LinkedList;

/*
두개의 정렬된(sorted) 정수 링크드리스트(linked list)가 주어지면, 두 리스트를 합친 정렬된 링크드리스트를 만드시오.
Given two sorted integer linked lists, merge the two linked lists. Merged linked list must also be sorted.
예제)
Input: 1->2->3, 1->2->3
Output: 1->1->2->2->3->3
Input: 1->3->5->6, 2->4
Output: 1->2->3->4->5->6
 */
public class O20200216 {
   public static void main(String[] args) {
      LinkedList<Integer> llin1= new LinkedList<Integer>();
      LinkedList<Integer> llin2= new LinkedList<Integer>();
      LinkedList<Integer> llout= new LinkedList<Integer>();
      llin1.add(1);
      llin1.add(3);
      llin1.add(5);
      llin1.add(6);
      
      llin2.add(2);
      llin2.add(4);
      llout.addAll(llin1);
      llout.addAll(llin2);
      llout.sort(null);
      
      System.out.println(llout);
   }
}