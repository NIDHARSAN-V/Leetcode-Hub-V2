class Solution {
    public int largestPerimeter(int[] n) {
        Arrays.sort(n);
        for(int i =n.length-1 ;i>=2;i--)
        {
            int a = n[i];
            int b = n[i-1];
            int c = n[i-2];

            // int s = a+b+c;
            if(c+b > a)
            {
                return a+b+c;
            }

        }
        return 0;
    }
}