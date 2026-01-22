class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        HashSet seen = new HashSet<>();
        HashSet repeated = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String substring = s.substring(i, i + 10);

            if (!seen.add(substring)) {
                repeated.add(substring);
            }
        }
        return new ArrayList<>(repeated);
    }
}