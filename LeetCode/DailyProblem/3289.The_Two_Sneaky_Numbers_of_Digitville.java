// Topics: HashTable, Math

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) map.put(num,map.getOrDefault(num,0)+1);
        int[] ans = new int[2];
        int idx = 0;
        for(Map.Entry<Integer,Integer> ent : map.entrySet()){
            if(ent.getValue()==2) ans[idx++] = ent.getKey();
            if(idx==2) break;
        }
        return ans;
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(n)
