// Topics: Priority-Queue

class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0 || k == 0) return ans;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < arr1.length && i < k; i++) {
            pq.offer(new int[]{arr1[i], arr2[0], 0}); 
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            ans.add(new ArrayList<>(Arrays.asList(cur[0], cur[1])));
            int idx = cur[2];

            if (idx + 1 < arr2.length) {
                pq.offer(new int[]{cur[0], arr2[idx + 1], idx + 1});
            }
        }

        return ans;

    }
}


// Time Complexity: O(nlogn)
// Auxiliary Space: O(n)
