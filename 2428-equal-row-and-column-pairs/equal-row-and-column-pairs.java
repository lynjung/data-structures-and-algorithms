class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rowdic = new HashMap<>(); // row - frequency
        for (int[] row : grid) {
            String stringRow = convertToString(row);
            rowdic.put(stringRow, rowdic.getOrDefault(stringRow, 0) + 1);
        }

        Map<String, Integer> coldic = new HashMap<>(); // column - frequency
        for (int i = 0; i < grid[0].length; i++) { // how many columns
            int[] currcol = new int[grid.length]; // build empty array of each column length
            for (int j = 0; j < grid.length; j++) { // length of each column
                currcol[j] = grid[j][i];
            }

            String stringCol = convertToString(currcol);
            coldic.put(stringCol, coldic.getOrDefault(stringCol, 0) + 1); // store completed currcol to coldic
        }

        int ans = 0;
        for (String s : rowdic.keySet()) {
            ans += rowdic.get(s) * coldic.getOrDefault(s, 0);
        }
        return ans;
    }

    public String convertToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append(",");
        }
        return sb.toString();
    }
}