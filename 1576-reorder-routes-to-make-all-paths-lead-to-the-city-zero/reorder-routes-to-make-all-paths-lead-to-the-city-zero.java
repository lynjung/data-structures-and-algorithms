class Solution {
    Set<String> roads = new HashSet<>(); // stores origial directions
    Map<Integer, List<Integer>> graph = new HashMap<>(); // stores which cities are connected, ignoring direction
    Set<Integer> seen = new HashSet<>(); // keeps track of cities we already visited

    public int minReorder(int n, int[][] connections) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            // put every city into the graph w/ empty neighbor list
        }

        for (int[] connection : connections) {
            int x = connection[0], y = connection[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
            // adds both directions to the graph so that it's undirected
            roads.add(convertToHash(x, y)); // save the original road direction
        }

        seen.add(0); // have seen this node
        return dfs(0); // start from city 0
    }

    public int dfs(int node) {
        int ans = 0;
        for (int neighbor : graph.get(node)) { // look at every city connected to the current city
            if (!seen.contains(neighbor)) { // only visit cities we haven't seen yet
                if (roads.contains(convertToHash(node, neighbor))) {
                    // if og road direction is node -> neighbor, we need to reverse it: increment ans
                    ans++;
                }

                seen.add(neighbor);
                ans += dfs(neighbor);
            }
        }

        return ans;
    }

    public String convertToHash(int row, int col) {
        return String.valueOf(row) + "," + String.valueOf(col);
    }
}