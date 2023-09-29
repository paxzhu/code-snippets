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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        int whole = 0, remainder = 0, cur_sum = 0;
        while(l1 != null || l2 != null) {
            int val_l1 = 0, val_l2 = 0;
            if(l1 != null) {
                val_l1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                val_l2 = l2.val;
                l2 = l2.next;
            }
            cur_sum = val_l1 + val_l2 + whole;
            whole = cur_sum / 10;
            remainder = cur_sum % 10;
            ListNode cur_node = new ListNode(remainder);
            tail.next = cur_node;
            tail = tail.next;
        }
        if(whole == 1) {
            tail.next = new ListNode(1);
        }
        return head.next;
    }
}