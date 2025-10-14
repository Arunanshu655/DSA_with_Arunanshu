// Topics: Hash-Table, Sorting

class Solution {
    public boolean isAna(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int[] freq = new int[26];
        int n = s1.length();
        for(int i = 0; i < n ; i++){
            freq[s1.charAt(i)-'a']++;
        }
        for(int i = 0; i < n ; i++){
            freq[s2.charAt(i)-'a']--;
            if(freq[s2.charAt(i)-'a']<0) return false;
        }

        for(int i = 0 ; i < 26 ; i++) if(freq[i]>0) return false;
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        ans.add(words[0]);
        for(int i = 1 ; i< n ;i++){
            if(!isAna(words[i],words[i-1])) ans.add(words[i]);
        }
        return ans;
    }
}

// Time Complexity: O(n * l); l = length of max length string
// Auxiliary Space: O(n);
