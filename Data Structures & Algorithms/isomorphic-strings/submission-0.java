class Solution {
    public boolean isIsomorphic(String s, String t) 
    {
       HashMap<Character, Character> mpp1 = new HashMap<>();
       HashMap<Character, Character> mpp2 = new HashMap<>();

       for(int i=0;i<s.length();i++)
       {
        char a = s.charAt(i);
        char b = t.charAt(i);

        if(mpp1.containsKey(a) && mpp1.get(a)!=b)
        {
            return false;
        }

        if(mpp2.containsKey(b) && mpp2.get(b)!=a)
        {
            return false;
        }

        mpp1.put(a,b);
        mpp2.put(b,a);

       }
       return true;

    }
}