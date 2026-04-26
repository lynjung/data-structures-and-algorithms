class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];

        for (char cha : letters) {
            count[cha - 'a']++; // ascii-> 'a'=97, 'b'=98, 'c'=99...
        }

        return backtrack(words, score, count, 0);
    }

    private int backtrack(String[] words, int[] score, int[] count, int index) {
        if (index == words.length) {
            return 0;
        }

        // option 1: skip current word
        int skip = backtrack(words, score, count, index + 1);

        // option 2: take current word if possible
        int wordScore = 0; // score of the current word
        boolean canTake = true;

        for (char c : words[index].toCharArray()) { // go through each letter in current word
            int letterIndex = c - 'a';

            count[letterIndex]--; // use one copy of the letter
            wordScore += score[letterIndex];

            if (count[letterIndex] < 0) {
                canTake = false;
            }
        }

        int take = 0;

        if (canTake) {
            take = wordScore + backtrack(words, score, count, index + 1);
        }

        // backtrack
        for (char c : words[index].toCharArray()) {
            count[c - 'a']++;
        }

        return Math.max(skip, take);
    }
}