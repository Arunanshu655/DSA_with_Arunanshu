// Topics: Tree

/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    // public int ans = 0;
    public int getSum(Node root, HashMap<Node,Integer> dp){
        
        if(root == null) return 0;
        
        if(dp.containsKey(root)) return dp.get(root);
        //not-take
        int nT = getSum(root.left,dp) + getSum(root.right,dp);
        
        //take
        int t = root.data;
        if(root.left != null){
            t += getSum(root.left.left,dp);
            t += getSum(root.left.right,dp);
        }
        if(root.right != null){
            t += getSum(root.right.left,dp);
            t += getSum(root.right.right,dp);
        }
        
        
         dp.put(root,Math.max(nT,t));
         return dp.get(root);
        
    }
    public int getMaxSum(Node root) {
        // code here
        HashMap<Node,Integer> dp = new HashMap<>();
        return getSum(root, dp);
        
    }
}


// Time Complexity: O(n)
// Auxiliary Space: O(n)
