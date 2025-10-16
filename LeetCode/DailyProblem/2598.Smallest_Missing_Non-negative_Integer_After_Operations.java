// Topics: HashTable, Math, Greedy

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
           if(num<0){
            num = (num % value) + value;
           }
           num %= value;
           map.put(num,map.getOrDefault(num,0)+1);
        }

        int ans = 0 , idx = 0;
        while(true){
            if(map.getOrDefault(idx,0)>0){
              map.put(idx,map.getOrDefault(idx,0)-1);
              ans++;
            }else break;

            idx = (idx+1)%value;
        }

        return ans;
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(log(value));
