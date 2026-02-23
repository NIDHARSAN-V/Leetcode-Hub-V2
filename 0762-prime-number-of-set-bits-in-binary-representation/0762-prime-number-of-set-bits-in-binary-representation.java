class Solution {
    public int countPrimeSetBits(int left, int right) {
        int n = right;
        int digits = (int)(Math.log(n) / Math.log(2)) + 1;
        List<Integer> li = sieve(digits);
        int count = 0;
        for(int i = left ; i <= right ; i++)
        {
          int x= Integer.bitCount(i);
          if(li.contains(x)) count++;
          

        }
        return  count;
    }

    public static List<Integer> sieve(int n) {

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}