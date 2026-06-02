class Solution {
    public int maxProduct(int[] nums) 
    {
        int maxsf=nums[0];
        int minsf=nums[0];
        int result=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            int curr=nums[i];

            if(curr<0)
            {
                int temp=maxsf;
                maxsf=minsf;
                minsf=temp;
            }

            maxsf=Math.max(curr,curr*maxsf);
            minsf=Math.min(curr,curr*minsf);

            result= Math.max(result,maxsf);
        }
        return result;
    }
}
