class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int low=0;
        int high=nums.length-1;
        int []result ={-1,-1};
        int last=-1;
        int first=-1;
        
        while(low<=high)
        {
            int mid = low+(high-low)/2;

            if(nums[mid]<=target)
            {
                low=mid+1;
            }
            else 
            {
                high=mid-1;
            }

            if(nums[mid]==target)
            {
                 last=mid;
            }
        }
        result[1]=last;


        low = 0;
        high = nums.length - 1;

        while(low<=high)
        {
            int mid = low+(high-low)/2;

            if(nums[mid]>=target)
            {
                high=mid-1;
            }
            else 
            {
                low=mid+1;
            }

            if(nums[mid]==target)
            {
                 first=mid;
            }
        }
        result[0]=first;

        return result;
    }
    
}