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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
        return head;
        int len = 1;
        ListNode temp = head;
        while(temp.next!=null){
            len++;
            temp = temp.next;
        } if(k%len == 0){
            return head;
        } k = k%len;
        temp.next = head;
        ListNode newlastnode = findnthnode(head, len - k);
        head = newlastnode.next;
        newlastnode.next = null;
        return head;
    }

    ListNode findnthnode (ListNode temp, int k ){
        int count = 1;
        while(temp!=null){
            if(count == k)
            return temp;
            count++;
            temp = temp.next;
        }
        return temp;
    }
}