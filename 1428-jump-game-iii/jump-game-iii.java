class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[arr.length];

        queue.add(start);
        seen[start] = true;

        while (!queue.isEmpty()) {
            int index = queue.remove();

            if (arr[index] == 0) {
                return true;
            }

            int backward = index - arr[index];
            int forward = index + arr[index];

            for (int jump : new int[]{backward, forward}) {
                if (jump >= 0 && jump < arr.length && !seen[jump]) {
                    seen[jump] = true;
                    queue.add(jump);
                }
            }
        }

        return false;
    }
}