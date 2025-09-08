// Topics: Merge Sort

/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node findMid(Node head){
        Node slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node merge(Node left, Node right){
        Node l = left , r = right, h ;
        if(l.data<r.data){
            h = l;
            l = l.next;
        }else {
            h = r;
            r = r.next;
        }
        Node temp = h;
        
        while(l != null && r != null){
            if(l.data<r.data){
                temp.next = l;
                l = l.next;
            }else{
                temp.next = r;
                r = r.next;
            }
            temp = temp.next;
        }
        
        if(l != null) temp.next = l;
        else if(r != null) temp.next = r;
        
        return h;
    }
    public Node mergeSort(Node head) {
        // code here
        if(head==null || head.next == null) return head;
        Node middle = findMid(head);
        Node leftHead = head, rightHead = middle.next;
        middle.next = null;
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        head = merge(leftHead, rightHead);
        
        return head;
    }
}

// Time Complexity: O(n log n)
// Auxiliary Space: O(n)
