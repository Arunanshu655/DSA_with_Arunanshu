// Topics: Stack, Monotonic Stack, Greedy

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        for(int i = 0 ; i < n ; i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && k > 0 && ch<st.peek()){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k-->0) st.pop();
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

        while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        return sb.length()==0?"0":sb.toString();
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(n);
  
