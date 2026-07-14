class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currmass = mass;

        for (int asteroid : asteroids) {
            if (asteroid > currmass) {
                return false;
            }
            currmass += asteroid;
        }
        return true;
    }
}