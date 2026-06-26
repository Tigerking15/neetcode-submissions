class Solution {
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int l = 0, r = 0;
        int maxLen = 0;
        int countOnes = 0;

        while (r < n) {

            if (nums[r] == 1) {
                countOnes++;
            }

            while ((r - l + 1) - countOnes > k) {
                if (nums[l] == 1) {
                    countOnes--;
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}