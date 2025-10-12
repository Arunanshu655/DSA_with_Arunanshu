// Topics: Tree


/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int ans = Integer.MIN_VALUE;
    int findMaxSub(Node root){
        if (root == null) return 0;

        int left = findMaxSub(root.left);
        int right = findMaxSub(root.right);

        int singlePath = Math.max(root.data, root.data + Math.max(left, right));

        int fullPath = Math.max(singlePath, root.data + left + right);

        ans = Math.max(ans, fullPath);

        return singlePath;
    }
    
    
    int findMaxSum(Node root) {
        // code here
        findMaxSub(root);
        return ans;
        
    }
}
// Time Complexity: O(n)
// Auxiliary Space: O(h)
