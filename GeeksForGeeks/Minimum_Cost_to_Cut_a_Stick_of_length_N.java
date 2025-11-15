// Topics: Dynamic Programming

class Solution {
    private HashMap<Integer,HashMap<Integer,Integer>> map;
    public int helper(int l, int r, int[] cuts){
        
        
        if(map.get(l).containsKey(r)) return map.get(l).get(r);
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < cuts.length ; i++){
            if(cuts[i]<r && cuts[i]>l) ans = Math.min(ans,(r-l) + helper(l, cuts[i], cuts) + helper(cuts[i], r, cuts));
        }
        ans = ( ans == Integer.MAX_VALUE )? 0 : ans;
        map.get(l).put(r,ans);
        return ans;
    }
    public int minCutCost(int n, int[] cuts) {
        // code here
        int m = cuts.length;
        map = new HashMap<>();
        map.put(0,new HashMap<>());
        for(int i = 0 ; i < m ; i++) map.put(cuts[i], new HashMap<>());
        
        return helper(0,n,cuts);
    }
}


// Time Complexity: O(m^3), m = cuts.size()
// Auxiliary Space: O(m^2)
