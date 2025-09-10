// Topics: Greedy

class Solution {
    public String largestSwap(String s) {
        // code here
        int beak = 0, n = s.length();
        for(int i = 1 ; i < n ; i++){
            if(s.charAt(i)>s.charAt(i-1)){
                beak = i;
                break;
            }
        }
        if(beak==0) return s;
        int big = n -1;
        for(int i = n -2 ; i>=beak ; i--){
            if(s.charAt(i)>s.charAt(big)){
                big = i;
            }
        }
        
        int small = beak - 1;
        for(int i = beak - 1 ; i >= 0 ; i--){
            if(s.charAt(i)>=s.charAt(big)) break;
            small = i;
        }
        
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(big,s.charAt(small));
        sb.setCharAt(small,s.charAt(big));
        
        return sb.toString();
    }
}

// Time Complesity: O(n);
// Auxiliary Space: O(1);
