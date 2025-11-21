// Topics: Greedy, sorting

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> 
        a[1] == b[1] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));
        int p1 = -1, p2 = -1, cnt = 0;
        for(int[] interval : intervals){
            int start = interval[0], end = interval[1];
            boolean c1 = (p1>=start && p1<=end);
            boolean c2 = (p2>=start && p2<=end);

            if(c1 & c2) continue;
            else if(c2){
                cnt++;
                p1 = p2;
                p2 = end;
            }else{
                cnt += 2;
                p1 = end - 1;
                p2 = end;
            }
        }
        return cnt;
    }
}

// Time COmplexity: O(n)
// Auxiliary Space: O(1) 
