// Topics: Math, Geometry

class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ans = 0;
        for(int i = 0; i < n; i++)
        for(int j = i+1; j < n; j++)
        for(int k = j+1; k < n; k++){
            int x1 = points[i][0];
            int y1 = points[j][0];
            int z1 = points[k][0];

            int x2 = points[i][1];
            int y2 = points[j][1];
            int z2 = points[k][1];

            double area = ((double)x1*(y2-z2)) + ((double)y1*(z2-x2)) + ((double)z1*(x2-y2));
            ans = Math.max(ans,Math.abs(area));

        }

        return (ans/2.0);
    }
}

// Time Complexity: O(n^3);
// Auxiliary space: O(1);
