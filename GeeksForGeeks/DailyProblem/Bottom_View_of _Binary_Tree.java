// Topics: Tree
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
class TreeNode{
    int line;
    Node pnt;
    TreeNode(int line,Node pnt){
        this.line = line;
        this.pnt = pnt;
    }
}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(new TreeNode(0,root));
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            int line = curr.line;
            map.put(curr.line, curr.pnt.data);
            
            if(curr.pnt.left != null){
                q.add(new TreeNode(line-1,curr.pnt.left));
            }
            if(curr.pnt.right != null){
                q.add(new TreeNode(line+1,curr.pnt.right));
            }
        }
        for(int key : map.keySet()) ans.add(map.get(key));
        return ans;
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(n)
