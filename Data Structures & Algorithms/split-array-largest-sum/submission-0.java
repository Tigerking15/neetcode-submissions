class Solution {
    public int splitArray(int[] nums, int k)
    {
        int low=maxFinder(nums);
        int high=sumFinder(nums);

        while(low<=high)
        {
            int mid=low+(high-low)/2;

            int countR=countCalc(nums,mid);

            if(countR>k)
            {
                low=mid+1;
            }
            else 
            {
               high=mid-1; 
            }
        }
        return low;
    }

    private int sumFinder(int [] arr)
    {
        int sum=0;
        for( int i =0; i<arr.length;i++)
        {
            sum+=arr[i];
        }
        return sum;
    }

     private int maxFinder(int [] arr)
    {
        int max=arr[0];
        for( int i =0; i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
        }
        return max;
    }

    private int countCalc(int [] nums, int midpoint)
    {
        int count=1;
        int sum=0;

        for(int i =0;i<nums.length;i++)
        {
            if(sum+nums[i]<=midpoint)
            {
                sum+=nums[i];
            }
            else 
            {
                count++;
                sum=nums[i];
            }
        }
        return count;
        
    }
}