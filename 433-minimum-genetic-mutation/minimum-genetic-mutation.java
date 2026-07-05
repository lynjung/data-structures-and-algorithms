class Pair {
    String gene;
    int steps;
    Pair(String gene, int steps) {
        this.gene = gene;
        this.steps = steps;
    }
}

class Solution {
    char[] choices = {'A', 'C', 'G', 'T'};

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();

        for (String gene : bank) {
            bankSet.add(gene);
        }

        if (!bankSet.contains(endGene)) {
                return -1;
            }

        Queue<Pair> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        queue.add(new Pair(startGene, 0));
        seen.add(startGene);

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            String gene = pair.gene;
            int steps = pair.steps;

            if (gene.equals(endGene)) {
                return steps;
            }

            for (String neighbor : neighbors(gene, bankSet)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.add(new Pair(neighbor, steps + 1));
                }
            }
        }

        return -1;
    }

    public List<String> neighbors(String gene, Set<String> bankSet) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < gene.length(); i++) {
            for (char c : choices) {
                if (gene.charAt(i) == c) {
                    continue;
                }

                String next = gene.substring(0, i) + c + gene.substring(i + 1);

                if (bankSet.contains(next)) {
                    ans.add(next);
                }
            }
        }

        return ans;
    }
}