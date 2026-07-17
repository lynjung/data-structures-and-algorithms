class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int maxUnits = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            int boxesTaken = Math.min(boxTypes[i][0], truckSize);

            maxUnits += boxesTaken * boxTypes[i][1];
            truckSize -= boxesTaken;

            if (truckSize == 0) {
                break;
            }
        }
        return maxUnits;
    }
}