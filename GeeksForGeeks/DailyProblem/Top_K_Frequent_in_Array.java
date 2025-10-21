// Topics: Hash, Sorting

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Code here
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int valA = map.get(a);
            int valB = map.get(b);
            if(valA != valB) return (map.get(b)-map.get(a));
            else return (b-a);
            
        });
        for(int a : arr) map.put(a,map.getOrDefault(a,0)+1);
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = 0; i<n ; ){
            while(i<n && i>0 && arr[i-1]==arr[i]) i++;
            if(i>=n) break;
            pq.add(arr[i++]);
        }
        for(int i = 0 ; i < k ; i++) ans.add(pq.poll());
        
        return ans;
        
    }
}


// Time Complexity: O(n log n)
// Auxiliary Space: O(n)
