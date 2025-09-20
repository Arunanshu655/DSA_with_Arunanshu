// Topics : Stack 

class Solution {
    public static int longestSubarray(int[] arr) {
        // code here
        int n = arr.length;
       Stack<Integer> st = new Stack<>();
       int[] next = new int[n];
       int[] prev = new int[n];
       
       for(int i = n-1 ; i >= 0 ; i--){
           while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
               st.pop();
           }
           if(st.isEmpty()) next[i] = n;
           else next[i] = st.peek();
           st.push(i);
       }
       st.clear();
       for(int i = 0 ; i < n ; i++){
           while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
               st.pop();
           }
           if(st.isEmpty()) prev[i] = -1;
           else prev[i] = st.peek();
           st.push(i);
       }
    //   for(int i = 0 ;i < n ; i++) System.out.println(prev[i]+" : "+next[i]);
       int len = 0;
       for(int i = 0 ; i < n ; i++){
           int temp = next[i]-prev[i]-1;
           if(temp>=arr[i])len = Math.max(len,temp);
       }
       return len;
    }
}

// Time cOmplexity : O(n);
// Auxiliary Space: O(n);
