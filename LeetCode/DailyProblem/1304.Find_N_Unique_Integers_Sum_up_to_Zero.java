// Topics : Math

class Solution {
    public int[] sumZero(int n) {
        if(n==1) return new int[]{0};
        int val = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(temp.size()<n){
            temp.add(val);
            temp.add(0-val);
            val++;
        }
        int m = temp.size();
        if(m>n){
            int last = temp.remove(m-1);
            temp.set(temp.size()-2,temp.get(temp.size()-2)+last);
        }
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++) ans[i] = temp.get(i);
        return ans;
    }
}

// Time Complexity: O(logn)
// Auxiliary Space: O(n)
