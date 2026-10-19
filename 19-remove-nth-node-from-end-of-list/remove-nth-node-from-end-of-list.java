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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head, newhead = null;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        } if (count == n) {
            newhead = head.next;
            return newhead;
        }
        int res = count - n;
        temp = head;
        ListNode deletenode = null;
        while(temp!=null){
            res --;
            if(res == 0)
            break;
            temp = temp.next;
        }
        deletenode = temp.next;
        temp.next = temp.next.next;
        return head;
    }
}