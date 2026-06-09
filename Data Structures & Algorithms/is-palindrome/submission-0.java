class Solution {
    public boolean isPalindrome(String s) 
    {
        s=s.toLowerCase().replaceAll("[^a-z0-9]","");
        StringBuilder sb = new StringBuilder(s);

        String rev=sb.reverse().toString();

        if(s.equals(rev))
        {
            return true;
        }
        return false;
    }
}
