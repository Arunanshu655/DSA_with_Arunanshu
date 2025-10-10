// Topics : Traversal, Tree

/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        Deque<Node> q = new LinkedList<>();
        boolean dir = false;
        
        q.addLast(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0 ; i < n ; i++){
                if(dir){
                    Node curr = q.pollLast();
                    ans.add(curr.data);
                    if(curr.right != null)q.addFirst(curr.right);
                    if(curr.left != null)q.addFirst(curr.left);
                }else{
                    Node curr = q.pollFirst();
                    ans.add(curr.data);
                    if(curr.left != null)q.addLast(curr.left);
                    if(curr.right != null)q.addLast(curr.right);
                }
                
            }
            dir = true^dir;
        }
        return ans;
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(n);
