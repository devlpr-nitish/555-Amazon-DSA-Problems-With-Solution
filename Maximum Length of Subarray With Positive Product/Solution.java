public class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n;) {
            int start = i;
            while (start < n && nums[start] == 0)
                start++;

            int end = start;
            int count = 0;
            int startneg = -1, endneg = -1;
            while (end < n && nums[end] != 0) {
                if (nums[end] < 0) {
                    count++;
                    if (startneg == -1)
                        startneg = end;
                    endneg = end;
                }
                end++;
            }
            if (count % 2 == 0) {
                maxLen = Math.max(maxLen, end - start);
            } else {
                if (startneg != -1) {
                    maxLen = Math.max(maxLen, end - startneg - 1);
                }
                if (endneg != -1) {
                    maxLen = Math.max(maxLen, endneg - start);
                }
            }

            i = end + 1;

        }
        return maxLen;
    }
}