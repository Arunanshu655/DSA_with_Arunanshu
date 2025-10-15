// Topics: Binary-Search Tree

/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public int pos = 0, ans = 0;
    public void searchKth(Node root, int k){
        if(pos == k) return;
        if(root == null) return;
        searchKth(root.left,k);
        if(pos==k) return ;
        pos++;
        ans = root.data;
        searchKth(root.right, k);
    }
    public int kthSmallest(Node root, int k) {
        // code here
        searchKth(root, k);
        if(pos != k) return -1;
        return ans;
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(h)
