// Topics: Array
// Math
// String
// Matrix

class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0, beams = 0;
        for(String row : bank){
            int curr = 0, n = row.length();
            for(int i = 0 ; i < n ; i++){
                if(row.charAt(i)=='1') curr++;
            }
            beams += (curr * prev);
            if(curr!=0) prev = curr;
        }

        return beams;
    }
}

// Time Complexity: O(m * n)
// Auxiliary Space: O(1)
