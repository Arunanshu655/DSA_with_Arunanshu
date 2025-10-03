// Topics: BackTracking, Recursion

class Solution {
    public ArrayList<String> ans ;
    public Map<Integer,char[]> map;
    public ArrayList<String> possibleWords(int[] arr) {
        // code here
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        map = new HashMap<>();
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
        backTrack(arr, 0, sb);
        
        return ans;
    }
    
    public void backTrack(int[] arr, int idx, StringBuilder sb){
        if(idx==arr.length){
            ans.add(sb.toString());
            return;
        }
        if(arr[idx]==1 || arr[idx]==0) {
           backTrack(arr, idx+1, sb); 
           return;
        } 
        
        for(char ch : map.get(arr[idx])){
            sb.append(ch);
            backTrack(arr, idx+1, sb);
            sb.delete(sb.length()-1,sb.length());
        }
        
    }
}

// Time Complexity: O(4 ^ n) // ignoring string builder to string conversion complexity
// Auxiliary Space: O(1)
  
