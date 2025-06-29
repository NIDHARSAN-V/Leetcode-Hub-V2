class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int ans[] = new int[temp.length];
        Stack <Integer> res = new Stack<>();

        for(int i =0 ;i<temp.length;i++)
        {
            if(res.size()==0 || temp[res.peek()]>=temp[i])
            {
                res.push(i);
            }
            else
            {
                while(  res.size()>0 && temp[res.peek()]<temp[i])
                {
                    int x = res.pop();
                    ans[x] = i-x;
                }
                res.push(i);
            }
        }

        return ans;

    }
}