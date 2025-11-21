// Topics: Hash-Table, String

class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] fst = new int[26];
        Arrays.fill(fst,-1);
        int[] lst = new int[26];
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(fst[ch-'a']==-1) fst[ch-'a'] = i;
            lst[ch-'a'] = i;
        }
        int ans = 0;
        for(int i = 0; i < 26 ; i++){
            int l = fst[i], r = lst[i];
            HashSet<Character> set =  new HashSet<>();
            for(int j = l + 1 ; j < r ; j++){
                set.add(s.charAt(j));
            }
            ans += set.size();
        }

        return ans;

    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(n)
