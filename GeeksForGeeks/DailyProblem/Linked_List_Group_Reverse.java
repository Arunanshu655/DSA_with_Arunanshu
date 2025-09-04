// Topics: Linked-List

/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node nextNode = new Node(-1);
    public Node reverseK(Node prev,Node curr,int pos,int k){
        if(pos==k || curr.next == null){
            Node temp = curr.next;
            curr.next = prev;
            nextNode = curr;
            return temp;
        }
        
        Node last = reverseK(curr,curr.next,pos+1,k);
        curr.next = prev;
        return last;
    }
    public Node reverseKGroup(Node head, int k) {
        // code here
        Node nextHead = head, temp = head;
        Node dummy = new Node(-1);
        dummy.next = head;
        int pos = 1;
        while(pos!=k && nextHead.next != null){
            nextHead = nextHead.next;
            pos++;
        }
        while(temp != null){
            Node temp2 = reverseK(dummy,temp,1,k);
            dummy.next = nextNode;
            dummy = temp;
            temp.next = temp2;
            temp = temp2;
        }
        
        return nextHead;
        
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(1)
