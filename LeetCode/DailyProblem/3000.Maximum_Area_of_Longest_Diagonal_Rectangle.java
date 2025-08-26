// Topics : Array

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int diag = 0, area = 0;
        for(int[] dimension : dimensions){
            int l = dimension[0];
            int w = dimension[1];
            int d = l * l + w * w;
            if(d>diag || (d==diag && area < (l*w))){
                area = l * w ;
                diag = d;
            } 
        }

        return area;
        
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(1);
