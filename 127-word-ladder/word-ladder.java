class Pair {
    String word;
    int steps;
    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Pair> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        queue.add(new Pair(beginWord, 1));
        seen.add(beginWord);

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            String word = pair.word;
            int steps = pair.steps;

            if (word.equals(endWord)) {
                return steps;
            }

            for (String neighbor : neighbors(word)) {
                if (wordSet.contains(neighbor) && !seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.add(new Pair(neighbor, steps + 1));
                }
            }
        }

        return 0;
    }

    public List<String> neighbors(String word) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (word.charAt(i) == c) {
                    continue;
                }

                ans.add(word.substring(0, i) + c + word.substring(i + 1));
            }
        }

        return ans;
    }
}