// Topics : Stack, Matrix

class Solution {
    static int lHist(int arr[]){
        Stack<Integer> st = new Stack<>();
        int max = 0, n = arr.length;
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                int top = st.pop();
                max = Math.max(max,(i-(st.isEmpty()?-1:st.peek())-1) * arr[top]);
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int top = st.pop();
            max = Math.max(max,(n-(st.isEmpty()?-1:st.peek())-1) * arr[top]);
        } 
        return max;
    }
    static int maxArea(int mat[][]) {
        // code here
        
        int m = mat.length, n = mat[0].length;
        int area = 0;
        for(int j = 0 ; j < n ; j++){
            int sum = 0;
            for(int i = 0 ; i < m ; i++){
              if(mat[i][j] ==0 ) sum = 0;
              else {
                  mat[i][j] += sum;
                  sum = mat[i][j];
              }
            }
        }
        
        // for(int[] m0 : mat){
        //     for(int m1 : m0) System.out.print(m1 + " ");
        //     System.out.println();
        // }
        for(int i = 0 ; i < m ; i++){
            area = Math.max(area,lHist(mat[i]));
        }
        
        return area;
        
    }
}

// Time Complexity: O(m*n)
// Auxiliary Space: O(1)
