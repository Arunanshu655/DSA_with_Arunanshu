// Topics : Stack, Strings

class Solution {
    public boolean isComp(char c1, char c2){
        switch(c1){
            case ')':
                return (c2=='(');
            case ']':
                return (c2=='[');
            case '}':
                return (c2=='{');
            case '>':
                return (c2=='<');
            default:
               return false;
        }
    }
    public int minParentheses(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && isComp(ch,st.peek())) st.pop();
            else if (ch=='(' || ch== ')')st.push(ch);
        }
        
        return st.size();
    }
}

// Time Complexity : O(n);
// Auxiliary Space : O(n);
