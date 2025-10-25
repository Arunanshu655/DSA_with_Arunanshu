// Topics: Greedy, Heap

class Solution {
    public int minOperations(int[] arr) {
        // code here
        double sum = 0, chngSum;
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        for (int a : arr) {
            sum += a;
            pq.add((double) a);
        }
        chngSum = sum;
        int cnt = 0;
        while (chngSum > sum / 2) {
            double curr = pq.poll();
            double reduce = curr / 2;
            chngSum -= reduce;
            pq.add(curr / 2);
            cnt++;
        }
        return cnt;
    }
}

// Time Complexity: O(n + k*log(n))
// Auxiliary Space: O(n)
