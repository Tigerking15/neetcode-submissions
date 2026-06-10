class Solution {
    public int trap(int[] height) 
    {
        int n = height.length;
        int ans=0;
        int[] lmax = calPrefix(height);
        int[] rmax = calSuffix(height);
        for(int i=0;i<n;i++)
        {
            ans+=Math.min(lmax[i],rmax[i]) - height[i];
        }
        return ans;
    }

    private int[] calPrefix(int[] arr)
    {
        int n=arr.length;
        int[] prefix = new int[n];
        prefix[0]=arr[0];
        for(int i =1;i<n;i++)
        {
            prefix[i] = Math.max(prefix[i-1], arr[i]);
        }
        return prefix;
    }

    private int[] calSuffix(int[] arr)
    {
        int n=arr.length;
        int[] suffix = new int[n];
        suffix[n-1]=arr[n-1];
        for(int i =n-2;i>=0;i--)
        {
            suffix[i] = Math.max(suffix[i+1], arr[i]);
        }
        return suffix;
    }
}

