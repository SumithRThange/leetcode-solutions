/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevhead = dummy;
        while(true){
            ListNode kth = prevhead;
            for(int i =0;i<k;i++){
                kth = kth.next;
                if(kth == null){
                    return dummy.next;
                }
            }
            ListNode nextgrp = kth.next;
            ListNode prev = nextgrp;
            ListNode curr = prevhead.next;
            while (curr != nextgrp){
                ListNode n = curr.next;
                curr.next = prev;
                prev = curr;
                curr = n;
            }
            ListNode newstart = prevhead.next;
            prevhead.next = kth;
            prevhead = newstart;
        }
    }
}