class Solution {
    public int shipWithinDays(int[] weights, int days) 
    {
        int low= MaxFinder(weights);
        int high= sumFinder(weights);

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int ndays=dayCalc(weights,mid);

            if(ndays<=days)
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

    private int sumFinder(int [] arr)
    {
        int sum=0;

        for(int i =0;i<arr.length;i++)
        {
            sum+=arr[i];
        }

        return sum;
    }


    private int dayCalc(int nums[], int cap)
    {
        int totaldays=1;
        int load=0;
        for(int i=0;i<nums.length;i++)
        {
            if(load+nums[i]>cap)
            {
                totaldays++;
                load=nums[i];
                
            }
            else 
            {
                load+=nums[i];
            }  
        }
        return totaldays;
    }
}