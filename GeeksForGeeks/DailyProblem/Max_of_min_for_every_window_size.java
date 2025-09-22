// Topics: Stack, Sliding-Window

class Solution {
    
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // code here
        int n = arr.length;
        int next[] = new int[n];
        int prev[] = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++) ans.add(Integer.MIN_VALUE);
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            prev[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n-1 ; i >= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            next[i] = (st.isEmpty()) ? n : st.peek();
            st.push(i);
        }
        for(int i = 0 ; i < n ; i++){
            int k = next[i] - prev[i] - 1;
            if(k>0)ans.set(k-1,Math.max(ans.get(k-1),arr[i]));
        }
        
        for(int i = n-2 ; i >= 0 ; i--)  ans.set(i,Math.max(ans.get(i),ans.get(i+1)));
        return ans;
    }
}

// Time Complexity : O(n)
// Auxiliary Space: O(n)
