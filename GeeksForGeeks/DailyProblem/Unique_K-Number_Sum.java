// Topics: BackTracking, Recursion

class Solution {
    public ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        // code here
        ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(n,k,temp,0,1); 
        return ans;
    }
    public void backTrack(int n, int k, List<Integer> temp, int sum, int curr){
        if(sum > n) return ;
        if(temp.size()==k){
            if(sum==n) ans.add(new ArrayList<>(temp));
            return ;
        }
        for(int i = curr; i <= 9 ; i++){
            temp.add(i);
            backTrack(n,k,temp,sum+i,i+1);
            temp.remove(temp.size()-1);
        }
    }
    
}

// Time Complexity: O(k * 2^9)
// Auxiliary Space: O(k)
