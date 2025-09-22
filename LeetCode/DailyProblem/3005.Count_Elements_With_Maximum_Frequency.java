// Topics: Counting, Hash Table

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
            max = Math.max(map.get(num),max);
        } 
        int ans = 0;
        for(int num : map.keySet()) if(max == map.get(num)) ans += max;
        return ans;
    }
}

// Time Complexity: O(n);
// Auxiliar Space: O(n);
