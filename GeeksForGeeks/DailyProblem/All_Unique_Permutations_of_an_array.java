// Topics: Recursion, BackTracking

class Solution {
    public static ArrayList<ArrayList<Integer>> ans;
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        // code here
        int n = arr.length;
        boolean[] visit = new boolean[n];
        List<Integer> temp = new ArrayList<>();
        ans = new ArrayList<>();
        Arrays.sort(arr);
        backTrack(arr,visit,temp);
        return ans;
        
    }
    public static void backTrack(int[] arr,boolean[] visit, List<Integer> temp){
        if(arr.length == temp.size()) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            if(visit[i]) continue;
                if(i>0 && arr[i]==arr[i-1] && !visit[i-1]) continue;
                
                visit[i] = true;
                temp.add(arr[i]);
                
                backTrack(arr,visit,temp);
                
                temp.remove(temp.size()-1);
                visit[i] = false;
            }
        }
};

// Time Complexity: O(n! * n)
// Auxiliary Space: O(n)
