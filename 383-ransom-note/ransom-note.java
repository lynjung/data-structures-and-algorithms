class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) - 1);
            if (counts.get(c) < 0) {
                return false;
            }
        }

        return true;
    }
}