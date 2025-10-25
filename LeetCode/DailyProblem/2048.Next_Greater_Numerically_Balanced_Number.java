// Topics: Hash Table, Math, Backtracking, Counting, Enumeration

class Solution {
    public boolean isBal(int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        while(n != 0){
            int rem = n % 10 ;
            map.put(rem,map.getOrDefault(rem,0)+1);
            n /= 10;
        }
        for(int key : map.keySet()){
            if(map.get(key) != key) return false;
        }

        return true;
    }
    public int nextBeautifulNumber(int n) {
        for(int i = n+1 ; i <= 7777777 ; i++ ){
            if(isBal(i)) return i;
        }
        return -1;
    }
}

// TIme Complexity: O(n)
// Auxiliary Space: O(1)
