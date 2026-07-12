class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < bombs.length; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) {
                    continue;
                }

                long dx = bombs[i][0] - bombs[j][0];
                long dy = bombs[i][1] - bombs[j][1];
                long radius = bombs[i][2];

                if (dx * dx + dy * dy <= radius * radius) {
                    graph.get(i).add(j);
                }
            }
        }
        
        int ans = 0;

        for (int i = 0; i < bombs.length; i++) {
            ans = Math.max(ans, bfs(i, graph));
        }

        return ans;
    }

    public int bfs(int start, Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        queue.add(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            int bomb = queue.remove();

            for (int neighbor : graph.get(bomb)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return seen.size();
    }
}