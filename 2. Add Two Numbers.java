/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in
 * reverse order and each of their nodes contain a single digit. Add the two numbers and return it as
 * a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        int x = l1.val, y = l2.val, carry = 0;
        int sum;
        while (l1 != null || l2 != null) {
            sum = x + y + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(l1 != null)
                l1 = l1.next;
            x = (l1 == null) ? 0 : l1.val;
            if(l2 != null)
                l2 = l2.next;
            y = (l2 == null) ? 0 : l2.val;
            carry = sum / 10;
            sum = x + y + carry;
        }
        if(carry == 1){
            curr.next = new ListNode(carry);
        }
        return res.next;
    }
}

// Given Lists are REVERSE ORDER
// Try to list every possible cases separately would be tedious
// l1 or l2 could be null
// If use (x + y + carry) as while condition will fail all cases start with [0][0]
