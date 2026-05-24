class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losecount = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            losecount.put(winner, losecount.getOrDefault(winner, 0));
            losecount.put(loser, losecount.getOrDefault(loser, 0) + 1);
        }

        List<List<Integer>> answer = Arrays.asList(new ArrayList<>(), new ArrayList<>());

        for (int player : losecount.keySet()) {
            if (losecount.get(player) == 0) {
                answer.get(0).add(player);
            }
            else if (losecount.get(player) == 1) {
                answer.get(1).add(player);
            }
        }

        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));

        return answer;
    }
}