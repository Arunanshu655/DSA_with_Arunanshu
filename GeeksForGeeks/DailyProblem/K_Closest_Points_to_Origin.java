// Topics: Heap, Sorting, Hash-Map

class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        // code here
        Map<int[],Double> map = new HashMap<>();
        for(int[] point : points){
            map.put(point, Math.sqrt(Math.pow(point[0],2) + Math.pow(point[1],2)));
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return ((map.get(a)-map.get(b))>0?1:-1);
        });
        for(int[] point: points) pq.add(point);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(curr[0]);
            temp.add(curr[1]);
            ans.add(temp);
            if(ans.size()==k) break;
        }
        
        return ans;
    }
}

// Time Complexity: O(n log k)
// Auxiliary Space: O(k)
