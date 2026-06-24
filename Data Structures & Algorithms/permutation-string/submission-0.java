class Solution 
{
    public boolean isSamefreq(int freq1[], int freq2[])
    {
        for(int i =0;i<26;i++)
        {
            if(freq1[i]!=freq2[i])
            {
                return false;
            }
        }
        return true;
    }


    public boolean checkInclusion(String s1, String s2) 
    {
        int freq[] = new int[26];
        Arrays.fill(freq,0);

        for(int i=0;i<s1.length();i++)
        {
            freq[s1.charAt(i)-'a']++;
        }

        int windSize= s1.length();

        for(int i =0;i<s2.length();i++)
        {
            int windIdx=0;
            int Idx=i;
            int windfreq[] = new int[26];
            Arrays.fill(windfreq,0);

            while(windIdx<windSize && Idx<s2.length())
            {
                windfreq[s2.charAt(Idx)-'a']++;
                windIdx++;
                Idx++;
            }

            if(isSamefreq(freq,windfreq))
            {
                return true;
            }

        }
        return false;
    }
}
