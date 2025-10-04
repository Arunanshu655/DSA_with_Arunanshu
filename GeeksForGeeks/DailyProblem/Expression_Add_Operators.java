// Topics: BackTrack, Recursion

class Solution {
    public ArrayList<String> ans ;
    public ArrayList<String> findExpr(String s, int target) {
        ans = new ArrayList<>();
        backTrack(s, target, 0, 0, 0, new StringBuilder());
        return ans;
    }

    private void backTrack(String s, int target, int idx, long currVal, long prevVal, StringBuilder expr) {
        if (idx == s.length()) {
            if (currVal == target)
                ans.add(expr.toString());
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (i != idx && s.charAt(idx) == '0') break;

            long num = Long.parseLong(s.substring(idx, i + 1));
            int len = expr.length();

            if (idx == 0) {
                expr.append(num);
                backTrack(s, target, i + 1, num, num, expr);
                expr.setLength(len);
            } else {
                expr.append('+').append(num);
                backTrack(s, target, i + 1, currVal + num, num, expr);
                expr.setLength(len);

                expr.append('-').append(num);
                backTrack(s, target, i + 1, currVal - num, -num, expr);
                expr.setLength(len);

                expr.append('*').append(num);
                backTrack(s, target, i + 1, currVal - prevVal + prevVal * num, prevVal * num, expr);
                expr.setLength(len);
            }
      
        }
      }
}

// Time Complexity: O(4^n)
// Auxiliary Space: O(n)
