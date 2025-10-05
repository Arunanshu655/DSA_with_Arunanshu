// Topics: Depth-First-Search

class Solution {
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights,pacific, 0, j, heights[0][j]);
            dfs(heights,atlantic, m - 1, j, heights[m - 1][j]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    void dfs(int[][] h, boolean[][] visited, int i, int j, int prev) {
        int m = h.length, n = h[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n  || visited[i][j ] || h[i][j] < prev) return;
        visited[i][j] = true;
        for (int[] d : dirs) dfs(h,visited,i + d[0],j + d[1],h[i][j]);
    }
}


// Time Copmplexity: O(mn)
// Auxiliary Space: O(mn)
