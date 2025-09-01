class Solution {
    public double maxAverageRatio(int[][] classes, int extra) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            double gainA = (classes[a][0] + 1.0) / (classes[a][1] + 1.0) - (double) classes[a][0] / classes[a][1];
            double gainB = (classes[b][0] + 1.0) / (classes[b][1] + 1.0) - (double) classes[b][0] / classes[b][1];
            return Double.compare(gainB, gainA); 
        });

        
        for (int i = 0; i < classes.length; i++) {
            pq.add(i);
        }

        while (extra > 0) {
            int index = pq.poll();
            classes[index][0] += 1;
            classes[index][1] += 1;
            pq.add(index);
            extra--;
        }

        
        double total = 0.0;
        for (int[] c : classes) {
            total += (double) c[0] / c[1];
        }

        return total / classes.length;
    }
}
