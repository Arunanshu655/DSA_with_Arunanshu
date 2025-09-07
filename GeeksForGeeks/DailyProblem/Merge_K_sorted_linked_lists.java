// Topics: Linked-List, Heap

class Solution {
    Node mergeKLists(Node[] arr) {
        // code here
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
            return (a.data-b.data);
        });
        Node dummy = new Node(-1);
        Node temp = dummy;
        for(Node a : arr) pq.add(a);
        while(!pq.isEmpty()){
            Node curr = pq.remove();
            temp.next = curr;
            temp = temp.next;
            curr = curr.next;
            if(curr != null) pq.add(curr);
        }
        return dummy.next;
    }
}

// Time Complexity: O(n log n)
// Auxiliary Space: O(n)
