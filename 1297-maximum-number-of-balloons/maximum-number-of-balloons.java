class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> count = new HashMap<>();
        count.put('b', 0);
        count.put('a', 0);
        count.put('l', 0);
        count.put('o', 0);
        count.put('n', 0);

        for (char c : text.toCharArray()) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            }
        }

        count.put('l', count.get('l') / 2);
        count.put('o', count.get('o') / 2);

        int min = count.get('b');
        for (int i : count.values()) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}