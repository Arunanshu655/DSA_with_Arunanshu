// Topics: Deque

class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        // code here
        k = k % dq.size();
        if(type == 1){
            while(k!=0){
                int ele = dq.pollLast();
                dq.addFirst(ele);
                k--;
            }
        }
        
        else if(type == 2){
            while(k!=0){
                int ele = dq.pollFirst();
                dq.addLast(ele);
                k--;
            }
        }
        
        
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(1);
