class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        int low=1;
        int high =MaxFinder(piles);

        while(low<=high)
        {
            int mid = low+(high-low)/2;

            long hours = hourCalc(piles,mid);
            if(hours<=(long)h)
            {
                high=mid-1;
            }
            else 
            {
                low=mid+1;
            }
            
        }
        return low;
    }




    private int MaxFinder(int [] arr)
    {
        int max=arr[0];

        for(int i =0;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
        }

        return max;
    }


    private long hourCalc(int nums[], int hourly)
    {
        long totalhours=0;
        for(int i=0;i<nums.length;i++)
        {
            totalhours += (long) Math.ceil((double) nums[i] / hourly);
        }
        return totalhours;
    }
}
