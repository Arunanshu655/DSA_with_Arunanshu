// Topics: Breadth First Search, Enumeration

class Solution {
    
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        
        String ans = s;
        while(!q.isEmpty()){
            String curr = q.poll();
            if (set.contains(curr)) continue;
            if(ans.compareTo(curr)>0) ans = curr;
            set.add(curr);
            StringBuilder add = new StringBuilder(curr);
            for(int i = 1 ; i < n ; i+=2){
                int val = add.charAt(i) - '0';
                val += a;
                val %= 10;
                add.setCharAt(i,(char)(val+'0'));
            }
            String addStr = add.toString();
            if(!set.contains(addStr)){
                q.add(addStr);
            }

            StringBuilder rotate = new StringBuilder(curr);
            String right = rotate.substring(n - b);
            String left = rotate.substring(0, n - b);
            rotate.setLength(0); 
            rotate.append(right).append(left);
            String rotStr = rotate.toString();

            if(!set.contains(rotStr)){
                q.add(rotStr);
            }
        }

        return ans;
    }
}

// Time Compleixty : O(l0 * n^3)
// Auxiliary Space: O(10 * n^2)
