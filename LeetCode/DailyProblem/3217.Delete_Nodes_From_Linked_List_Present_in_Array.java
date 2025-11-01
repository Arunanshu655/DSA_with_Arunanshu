// Topics: Linked List, Hash Table

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        while((head != null )&&  (set.contains(head.val))){
            head = head.next;
        }

        ListNode temp = head;
        while(temp != null && temp.next != null){
            if(set.contains(temp.next.val)) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return head;
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(n)
