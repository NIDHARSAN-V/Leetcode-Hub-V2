class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0 ;
        int j = 0;
        int ans = 0;
        while(i < players.length && j < trainers.length)
        {
            if(players[i]<=trainers[j])
            {
                i++;
                j++;
                ans++;
            }
            else if(players[i] > trainers[j])
            {
                j++;
            }
        }
        return ans;
    }
}