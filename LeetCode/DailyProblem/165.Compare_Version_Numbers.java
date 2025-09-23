// Topics: String, Two pointers

class Solution {
    public int compareVersion(String version1, String version2) {
        int r1 = 0, r2 =0;
        int n1 = version1.length(), n2 = version2.length();
        while(r2<n2 || r1 < n1){
            int num1 = 0, num2 = 0;
            while(r1<n1 && version1.charAt(r1) != '.') num1 = (num1*10) + (version1.charAt(r1++) - '0');
            while(r2<n2 && version2.charAt(r2) != '.') num2 = (num2*10) + (version2.charAt(r2++) - '0');

            if(num1>num2) return 1;
            else if(num2>num1) return -1;
            r1++;
            r2++;
        }

        return 0;
    }
}

// Time Complexity: O(N);
// Auxiliary Space: O(1);
