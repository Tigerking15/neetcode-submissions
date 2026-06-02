class Solution {
    public List<Integer> majorityElement(int[] nums) 
    {
        int cnt1=0;
        int cnt2=0;
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;
        int n=nums.length;

        for(int i=0;i<nums.length;i++)
        {
            if(cnt1==0 && nums[i]!=el2)
            {
                cnt1=1;
                el1=nums[i];
            }
            else if (cnt2==0 && nums[i]!=el1)
            {
                cnt2=1;
                el2=nums[i];
            }
            else if(nums[i]==el1)
            {
                cnt1++;
            }
            else if(nums[i]==el2)
            {
                cnt2++;
            }
            else
            {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> list=new ArrayList<>();

        int realcount1=0;
        int realcount2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==el1) realcount1++;
            if(nums[i]==el2) realcount2++;
        }

        int majority= (int)(n/3)+1;
        if(realcount1>=majority) list.add(el1);
        if(realcount2>=majority) list.add(el2);
        Collections.sort(list);

        return list;
    }

}