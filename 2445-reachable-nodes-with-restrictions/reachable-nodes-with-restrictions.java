class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> res = new HashSet<>();
    boolean[] seen;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        seen = new boolean[n];

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }

        for (int restrict : restricted) {
            res.add(restrict);
        }

        return dfs(0);
    }

    public int dfs(int node) {
        if (res.contains(node) || seen[node]) {
            return 0;
        }

        seen[node] = true;
        int count = 1;

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            count += dfs(neighbor);
        }
        return count;
    }
}