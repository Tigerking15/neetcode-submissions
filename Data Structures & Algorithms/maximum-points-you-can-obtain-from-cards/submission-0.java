class Solution {
    public int maxScore(int[] cardPoints, int k) 
    {
        int n = cardPoints.length;
        int totalSum=0;

        for(int x : cardPoints)
        {
            totalSum+=x;
        }

        if(k==n)
        {
            return totalSum;
        }

        int windowSize=n-k;
        int windSum=0;

        for(int i =0;i<windowSize;i++)
        {
            windSum+=cardPoints[i];
        }
        
        int minWindow= windSum;

        for(int i = windowSize;i<n;i++)
        {
            windSum+=cardPoints[i];
            windSum-=cardPoints[i-windowSize];

            minWindow = Math.min(minWindow, windSum);
        }

        return totalSum-minWindow;

    }
}