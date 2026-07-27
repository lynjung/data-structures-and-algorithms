class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        curr.add(0);
        backtrack(curr, 0, ans, graph);

        return ans;
    }

    public void backtrack(List<Integer> curr, int i, List<List<Integer>> ans, int[][] graph) {
        if (i == graph.length - 1) {
            ans.add(new ArrayList(curr));
            return;
        }

        for (int neighbor : graph[i]) {
            curr.add(neighbor);
            backtrack(curr, neighbor, ans, graph);
            curr.remove(curr.size() - 1);
        }
    }
}