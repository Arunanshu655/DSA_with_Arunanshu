// Topics: Maths, Enumeration, Geometry

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length, count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i==j) continue;
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                
                if(x1<=x2 && y1>=y2){
                    boolean hasConflict = false;
                    for(int k = 0 ; k<n ; k++){
                        if(k==i || k==j) continue;
                        int x3 = points[k][0], y3 = points[k][1];
                        if(x1 <= x3 && x3 <= x2 && y1 >= y3 && y3 >= y2){
                            hasConflict = true;
                            break;
                        }

                    }
                    if(!hasConflict) count++;                    
                }
            }
        }
        return count;
    }
}

// Time COmplexity: O(n^3);
// Auxiliary Space: O(1);
