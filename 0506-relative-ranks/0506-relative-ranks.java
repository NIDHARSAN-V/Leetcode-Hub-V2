class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];

        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[0] > a[0]) return 1;    
            else if (b[0] < a[0]) return -1;
            else return 0;
        });


       
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{score[i], i});
        }

        int rank = 1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int index = cur[1];

           
            if (rank == 1) res[index] = "Gold Medal";
            else if (rank == 2) res[index] = "Silver Medal";
            else if (rank == 3) res[index] = "Bronze Medal";
            else res[index] = String.valueOf(rank);

            rank++;
        }

        return res;
    }
}
