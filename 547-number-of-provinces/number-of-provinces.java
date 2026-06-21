class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] seen;

    public int findCircleNum(int[][] isConnected) {
        // build the graph
        int n = isConnected.length;
        for (int i = 0; i < n; i++) { // loops thru first city
            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
                // if city i not in graph, add it w/ empty neighbor list
            }
            for (int j = i + 1; j < n; j++) { // loops thru second city
                // bc matrix is symmetric, no need to check both
                if (!graph.containsKey(j)) {
                    graph.put(j, new ArrayList<>());
                    // if city j not in graph, add it w/ empty neighbor list
                }
                if (isConnected[i][j] == 1) {
                    // if city i & j are connected, add them as neighbors of each other
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        seen = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                // add all nodes of a connected component to the set
                // city hasn't been visited yet -> found a new province
                ans++;
                seen[i] = true;
                dfs(i); // visit all cities in this province
            }
        }

        return ans;
    }

    public void dfs(int node) {
        for (int neighbor : graph.get(node)) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                dfs(neighbor);
            }
        }
    }
}