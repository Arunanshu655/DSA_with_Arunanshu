// Topics: Graph, shortest path

class Solution {

    public int minCost(String s, String t, char[][] transform, int[] cost) {
        // code here
        if(s.length() != t.length()) return -1;
        int n = s.length(), idx = 0;
        int[][] transformer = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(transformer[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < 26; i++) {
            Arrays.fill(transformer[i], Integer.MAX_VALUE);
            transformer[i][i] = 0;  
        }
        for (int i = 0; i < transform.length; i++) {
            int x = transform[i][0] - 'a';
            int y = transform[i][1] - 'a';
            transformer[x][y] = Math.min(transformer[x][y], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (transformer[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 0; j < 26; j++) {
                    if (transformer[k][j] == Integer.MAX_VALUE) continue;
                    transformer[i][j] = Math.min(transformer[i][j],
                                      transformer[i][k] + transformer[k][j]);
                }
            }
        }
            
       
        int totCost = 0;
        for(int i = 0 ; i < n; i++){
            int ch1 = s.charAt(i)-'a', ch2 = t.charAt(i)-'a';
            if(ch1 == ch2) continue;
            
            int minCost = Integer.MAX_VALUE;
            for(int k = 0 ; k < 26 ; k++){
                if(transformer[ch1][k] == Integer.MAX_VALUE ||
                transformer[ch2][k] == Integer.MAX_VALUE) continue;
                minCost = Math.min(minCost, transformer[ch1][k] + transformer[ch2][k]);
            }
            if (minCost == Integer.MAX_VALUE) return -1;
            totCost += minCost;
        }
        
        return totCost;
    }
}

Time Complexity: O(n)
Auxiliary Space: O(1)
