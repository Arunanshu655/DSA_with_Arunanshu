// Topics: Two Pointers, Greedy

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1, maxWater = 0;
        while(i<j){
            maxWater = Math.max(maxWater,(j-i) * (Math.min(height[i],height[j])));
             if(height[j]<height[i]){
                int curr = height[j];
                while(j>i && curr>=height[j]) j--;
             }else{
                int curr = height[i];
                while(j>i && curr>=height[i]) i++;
             }
        }
        return maxWater;
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(n);
