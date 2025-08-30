// Topics: Stack, Matrix

class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            if(st.isEmpty()){
                st.push(i);
                continue;
            }
            int curr = st.peek();
            if(mat[curr][i]==0) continue;
            else {
                st.pop();
                st.push(i);
            }
        }
        boolean isKnown = true;
        for(int i = 0 ; i < n ; i++){
            if(i != st.peek() && mat[i][st.peek()]==0){
                isKnown = false;
                break;
            }
        }
        
        boolean knows = false;
        for(int i = 0 ; i < n ; i++){
            if(i != st.peek() && mat[st.peek()][i]==1){
                knows = true;
                break;
            }
        }
        
        return (isKnown && !knows) ? st.peek() : -1;
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(1)
