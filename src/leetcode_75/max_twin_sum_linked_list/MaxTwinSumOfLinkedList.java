package leetcode_75.max_twin_sum_linked_list;

import java.util.Stack;

public class MaxTwinSumOfLinkedList {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public int pairSum(ListNode head) {


        Stack<Integer> tail = new Stack<>();
        ListNode working = head;


        while (working.next != null){
            tail.push(working.val);
            working = working.next;
        }

        int count = tail.size() / 2;
        int maxSum = 0;

        working = head;

        while (count > 0){
            int sum = working.val + tail.pop();
            maxSum = Math.max(sum, maxSum);
            working = working.next;
        }


        return maxSum;
    }



}
