// Topics: Binary Search Tree

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    public void inOrder(Node root){
        if(root ==  null) return;
        inOrder(root.left);
        arr.add(root.data);
        inOrder(root.right);
        
    }
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        // code here
        inOrder(root);
        int idx  = 0;
        int n = arr.size();
        if(k>=n){
            for(int i = 0 ; i < (k-n) ; i++) arr.addFirst(0);
            return arr;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        
        for( ; idx < n-1 ; idx++){
           if(Math.abs(arr.get(idx)-target)<=Math.abs(arr.get(idx+1)-target)) break;
        }
        ans.add(arr.get(idx));
        int l = idx - 1, r = idx+1;
        while(ans.size()<k){
            if(l<0){
                ans.add(arr.get(r++));
                continue;
            }
            if(r>=n){
               ans.add(arr.get(l--));
               continue;
            } 
            
            if(Math.abs(target-arr.get(r)) < Math.abs(target-arr.get(l))){
                ans.add(arr.get(r++));
                continue;
            }
            
            else{
                ans.add(arr.get(l--));
                continue;
            }
        }
        
        return ans;
        
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(n)
  
