// Topics: Hash Table, Counting

class Solution {
    public boolean isVow(char ch){
        return(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u');
    }
    public int maxFreqSum(String s) {
        int[] alpha = new int[26];
        int vow = 0, con = 0, n = s.length();
        for(int i = 0 ; i < n ; i++){
            alpha[s.charAt(i)-'a']++;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(isVow((char)('a'+i))){
                vow = Math.max(alpha[i],vow);
            }else con = Math.max(alpha[i],con);
        }
        return (vow + con);
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(1);
