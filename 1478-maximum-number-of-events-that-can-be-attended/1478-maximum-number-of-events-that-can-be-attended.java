class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0, n = events.length, res = 0;
        
        int day = 1;
        int maxDay = 0;
        for (int[] e : events) {
            maxDay = Math.max(maxDay, e[1]);
        }


        while(day <= maxDay)
        {
            
              while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }


            while(!pq.isEmpty() && pq.peek() < day)
            {
                pq.poll();
            }


            if(!pq.isEmpty())
            {
                pq.poll();
                res++;

            }

            day++;


            

        }

        return res;

    }
}