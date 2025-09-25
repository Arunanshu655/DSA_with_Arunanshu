// Topics: Dynamic Programming

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        for(int i = n - 2 ; i >= 0 ; i--){
            int m = triangle.get(i).size();
            for(int j = 0; j < m ; j++){
               triangle.get(i).set(j,Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))+triangle.get(i).get(j));
            }
        }

        return triangle.get(0).get(0);
    }
}

// Time Complexity: O(n^2)
// Auxiliary Space: O(1)
