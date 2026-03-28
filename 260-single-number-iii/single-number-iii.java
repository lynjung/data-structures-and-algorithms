class Solution {
    public int[] singleNumber(int[] nums) {
        
        HashSet<Integer> hashset = new HashSet<>();

        for (int num : nums) {
            if (hashset.contains(num)) {
                hashset.remove(num);
            }
            else {
                hashset.add(num);
            }
        }
        int[] result = new int[hashset.size()];
        int i = 0;
        for (int num : hashset) {
            result[i++] = num;
        }
        return result;
    }
}