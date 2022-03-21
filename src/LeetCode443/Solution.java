package LeetCode443;

import java.util.*;

/**
 * 图的广度优先遍历。
 *
 * @author Chanmoey
 * @date 2022年03月21日
 */
class Solution {

    /**
     * Java 17 可以改为 record。
     */
    private static class Pari {
        private final String gene;
        private final int step;

        public Pari(String gene, int step) {
            this.gene = gene;
            this.step = step;
        }
    }

    private static final char[] GENE_BANK = {'A', 'T', 'C', 'T'};

    public int minMutation(String start, String end, String[] bank) {

        if (start.equals(end)) {
            return 0;
        }

        if (bank.length == 0 || this.indexOf(bank, end) == -1) {
            return -1;
        }

        Set<String> bankSet = new HashSet<>(bank.length * 2);
        Set<String> visited = new HashSet<>();
        Collections.addAll(bankSet, bank);

        Queue<Pari> queue = new LinkedList<>();
        queue.add(new Pari(start, 0));
        visited.add(start);
        while (!queue.isEmpty()) {
            Pari cur = queue.poll();
            String curGene = cur.gene;
            int step = cur.step + 1;
            Set<String> nextSet = new HashSet<>();
            this.getNext(nextSet, curGene.toCharArray());

            for (String next : nextSet) {
                if (bankSet.contains(next) && !visited.contains(next)) {
                    queue.add(new Pari(next, step));
                    visited.add(next);
                    if (end.equals(next)) {
                        return step;
                    }
                }
            }
        }

        return -1;
    }

    private void getNext(Set<String> next, char[] gene) {

        for (int i = 0; i < gene.length; i++) {
            char cur = gene[i];

            gene[i] = 'A';
            next.add(String.valueOf(gene));

            gene[i] = 'T';
            next.add(String.valueOf(gene));

            gene[i] = 'C';
            next.add(String.valueOf(gene));

            gene[i] = 'G';
            next.add(String.valueOf(gene));

            gene[i] = cur;
        }
    }

    private int indexOf(String[] bank, String gene) {
        for (int i = 0; i < bank.length; i++) {
            if (gene.equals(bank[i])) {
                return i;
            }
        }

        return -1;
    }
}
