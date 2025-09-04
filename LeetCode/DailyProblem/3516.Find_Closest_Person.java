// Topics: Math

class Solution {
    public int findClosest(int x, int y, int z) {
        int distX = Math.abs(x-z);
        int distY = Math.abs(y-z);
        return (distX==distY)?0:(distX>distY) ? 2 : 1;
    }
}

// Time Complexity: O(1);
// Ausiliary Space: O(1);
