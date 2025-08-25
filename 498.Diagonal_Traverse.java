//Topics: Matrix

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int i = 0, j = 0, m = mat.length, n = mat[0].length, idx=0;
        boolean dir = false;
        int[] ans = new int[m*n];
        while(idx<m*n){
            ans[idx++] = mat[i][j];
            boolean isChanged = false;
            if (!dir) {
                if (j == n - 1) {
                    i++;
                    dir = true;
                } else if (i == 0) {
                    j++;
                    dir = true;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == m - 1) {
                    j++;
                    dir = false;
                } else if (j == 0) {
                    i++;
                    dir = false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return ans;
    }
}

// Time Complexity: O(m*n)
//Auxiliary Space: O(m*n)
