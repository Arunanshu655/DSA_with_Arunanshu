// Topics: String , Greedy

class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // code here
        int i = 0, j = 0, n1 = s1.length(), n2 = s2.length();
        while(i<n1 && j<n2){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
            }else j++;
        }
        return i==n1;
    }
};

// Time complexity: O(n)
// Space Complexity: O(1)
