// Topics: Graph, DAG, BFS, Topiological Sort

import java.util.*;

class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // Array to store in-degree (number of prerequisites) for each course
        int[] indegree = new int[n];
        
        // Adjacency list representation of graph
        // adj.get(i) -> list of courses that depend on course i
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph and compute in-degrees
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            adj.get(prerequisite).add(course);  // Edge: prerequisite → course
            indegree[course]++;                 // Increment in-degree of course
        }

        // Queue for BFS — store all courses with no prerequisites (in-degree = 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // List to store the topological order (course order)
        ArrayList<Integer> order = new ArrayList<>();

        // Perform Kahn’s Algorithm (BFS-based Topological Sort)
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);

            // Reduce in-degree of all dependent courses
            for (int next : adj.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next); // Add course when all its prerequisites are done
                }
            }
        }

        // If all courses are included, return the order
        // Otherwise, return an empty list (cycle detected)
        return order.size() == n ? order : new ArrayList<>();
    }
}


// Time Complexity: O(n + m)
// Auxiliary Space: O(n + m)
