// Topics: Linked-List


class Solution {
    public int findLength(Node head){
        if(head==null) return 0;
        Node temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    public Node swapKth(Node head, int k) {
        // code here
        int n = findLength(head);
        Node swap = null;
        int idx = 1;
        Node temp = head;
        while(temp != null){
            if(idx==k){
                if(swap!=null){
                    int t = swap.data;
                    swap.data = temp.data;
                    temp.data = t;
                    break;
                }else swap = temp;
            }
            else if(idx==(n-k+1)){
                if(swap!=null){
                    int t = swap.data;
                    swap.data = temp.data;
                    temp.data = t;
                    break;
                }else swap = temp;
            }
            temp = temp.next;
            idx++;
        }
        return head;
    }
}


// Time Complexity: O(n)
// Auxiliary Space: O(1)
