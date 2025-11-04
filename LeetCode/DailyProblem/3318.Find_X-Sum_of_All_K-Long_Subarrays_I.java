// Topics: Hash Table, Heap, Sliding Window

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length, l = 0, r = k - 1, lost = -1, get = -1, idx = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[n-k+1];
        for(int i = 0 ; i < r; i++) map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
                if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
                else return Integer.compare(a[1],b[1]);
        });
        
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            int sum = 0;
            for(Map.Entry<Integer,Integer> ele : map.entrySet()){
                pq.add(new int[]{ele.getValue(),ele.getKey()});
                while(pq.size()>x) pq.poll();
            }
            while(!pq.isEmpty()){
                int curr[] =  pq.poll();
                sum += (curr[0] * curr[1]);
            } 
            ans[idx++] = sum;
            map.put(nums[l],map.getOrDefault(nums[l],0)-1);
            if(map.get(nums[l])<=0) map.remove(nums[l]);
            l++;
            r++;
        }
        return ans;
       
    }
}

// Time Complexity: O(n * k log x)
// Auxiliary Space: O(k + x)
