// Topics: Linked-List

/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int findLen(Node one, Node two){
        int cnt = 1;
        one = one.next;
        while(one != two){
            cnt++;
            one = one.next;
        }
        return cnt;
    }
    public int lengthOfLoop(Node head) {
        // code here
        Node one = head, two = head;
        while(two != null && two.next != null){
            one = one.next;
            two = two.next.next;
            if(one==two) return findLen(one,two);
        }
        return 0;
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(1)
