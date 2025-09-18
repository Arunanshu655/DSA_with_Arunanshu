// Topics: Stack

class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = n-1 ; i >=0 ; i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()) ans.add(0,-1);
            else ans.add(0,st.peek());
            st.push(arr[i]);
        }
        for(int i = n-1 ; i >=0 ; i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()) ans.set(i,st.peek());
            st.push(arr[i]);
        }
        
        return ans;
    }
}
// Time Conplexity: O(n);
// Auxiliary Space: O(n);
