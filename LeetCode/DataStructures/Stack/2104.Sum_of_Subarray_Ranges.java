// Topics: Stack, monotonic stack


class Solution {
    public void findPge(int[] arr, int[] pge) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) st.pop();
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    public void findNge(int[] arr, int[] nge) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) st.pop();
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    public void findPse(int[] arr, int[] pse) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    public void findNse(int[] arr, int[] nse) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    public long sumSubMins(int[] arr) {
        int n = arr.length;
        long total = 0;
        int[] nse = new int[n];
        int[] pse = new int[n];
        findNse(arr, nse);
        findPse(arr, pse);
        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            total += (long) left * right * arr[i];
        }
        return total;
    }

    public long sumSubMaxs(int[] arr) {
        int n = arr.length;
        long total = 0;
        int[] nge = new int[n];
        int[] pge = new int[n];
        findNge(arr, nge);
        findPge(arr, pge);
        for (int i = 0; i < n; i++) {
            int left = i - pge[i];
            int right = nge[i] - i;
            total += (long) left * right * arr[i];
        }
        return total;
    }

    public long subArrayRanges(int[] nums) {
        return sumSubMaxs(nums) - sumSubMins(nums);
    }
}


// Time Complexity: O(n);
// Auxiliary Space: O(n);
