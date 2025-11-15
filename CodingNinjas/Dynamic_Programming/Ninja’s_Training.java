// Topics: Dynamic Programming

public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int max1 = 0 , max2 = 0, k = 0; 
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = 0 ; j < 3 ; j++){
                if(k!=j)points[i][j] += max1;
                else points[i][j] += max2;
            }
            max1 = 0; max2 = 0;
            for(int j = 0 ; j < 3 ; j++){
                if(points[i][j] > max1){
                    max2 = max1;
                    max1 = points[i][j];
                    k = j;
                }else if(points[i][j] > max2){
                    max2 = points[i][j];
                }
            }
        }
        return Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
    }

}


// Time Complexity: O(n)
// Auxiliary Space: O(1)
