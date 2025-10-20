// Topics: Binary Search Tree


// Super Hack Solution: *************************
class Solution {
    public int bstCnt(int idx, int l, int r){
        if(r-l<0) return 1;
        if(r-l==1) return 2;
        
        ret
        
    }
    public ArrayList<Integer> countBSTs(int[] arr) {
        // Code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i = 0 ; i < n ; i++) map.put(arr[i],i);
        Arrays.sort(arr);
        int[] bstNum = new int[7];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i<n ; i++) ans.add(0);
        bstNum[0] = 1;
        bstNum[1] = 1;
        bstNum[2] = 2;
        bstNum[3] = 5;
        bstNum[4] = 14;
        bstNum[5] = 42;
        bstNum[6] = 132;
        
        for(int i = 0 ; i < n ; i++){
            ans.set(map.get(arr[i]),bstNum[i] * bstNum[n-i-1]);
        }
        
        return ans;
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(n)
