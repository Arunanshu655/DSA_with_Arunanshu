// Topics: Stadck, Greedy

// Q :=> The stock span problem is a financial problem where we have a series of daily price quotes for a stock and we need to calculate the span of stock price for all days.
// You are given an array arr[] representing daily stock prices, the stock span for the i-th day is the number of consecutive days up to day i (including day i itself) for
//   which the price of the stock is less than or equal to the price on day i. Return the span of stock prices for each day in the given sequence.


class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        Stack<int[]> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            int cnt = 1;
            while(!st.isEmpty() && st.peek()[0]<=arr[i]){
                cnt += st.pop()[1];
            }
            st.push(new int[]{arr[i],cnt});
            ans.add(cnt);
        }
        return ans;
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(n);
