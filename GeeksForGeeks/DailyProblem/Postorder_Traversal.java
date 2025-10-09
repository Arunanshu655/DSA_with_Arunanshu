// Topics: Tree

/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> ans = new ArrayList<>();
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        if(root==null) return ans;
        postOrder(root.left);
        postOrder(root.right);
        ans.add(root.data);
        
        return ans;
    }
}


// Time Complexity: O(n)
// Auxiliary Space: O(1) // ignore call stack
