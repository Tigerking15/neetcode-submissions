class Solution {
    public int longestConsecutive(int[] nums) 
    {
        int n=nums.length;

        List<Integer> list=new ArrayList<>();

         if(n == 0)
        {
            return 0;
        }

        for(int i =0;i<n;i++)
        {
            list.add(nums[i]);
        }

        Collections.sort(list);

        int longestStreak=1;
        int currentStreak=1;

        for(int i =1;i<list.size();i++)
        {
            if(list.get(i)== list.get(i-1))
            {
                continue;
            }

            if(list.get(i)==list.get(i-1)+1)
            {
                currentStreak++;
            }
            else
            {
                longestStreak=Math.max(longestStreak,currentStreak);
                currentStreak=1;
            }
        }
        longestStreak = Math.max(longestStreak, currentStreak);
        return longestStreak;
    }
}
