class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();

        int[] hash = new int[26];

        int l = 0;
        int r = 0;
        int maxLen = 0;
        int maxfreq = 0;

        while (r < n) {

            hash[s.charAt(r) - 'A']++;
            maxfreq = Math.max(maxfreq, hash[s.charAt(r) - 'A']);

            while ((r - l + 1) - maxfreq > k) {
                hash[s.charAt(l) - 'A']--;
                l++;

                maxfreq = 0;
                for (int i = 0; i < 26; i++) {
                    maxfreq = Math.max(maxfreq, hash[i]);
                }
            }

            maxLen = Math.max(maxLen, r - l + 1);

            r++;
        }

        return maxLen;
    }
}