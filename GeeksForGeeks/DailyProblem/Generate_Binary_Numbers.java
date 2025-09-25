// Topics: Queue, Bit Magic

class Solution {

    public ArrayList<String> generateBinary(int n) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        for(int i = 0 ; i < n ; i++){
            String curr = q.poll();
            ans.add(curr);
            q.add(curr + "0");
            q.add(curr + "1");
        }
        return ans;
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(n);
