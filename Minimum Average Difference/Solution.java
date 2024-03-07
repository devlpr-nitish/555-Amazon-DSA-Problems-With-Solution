public class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int minIndex = -1;
        int minAvg = Integer.MAX_VALUE;

        long lsum = 0, rsum = 0;

        for (int i = 0; i < n; i++) {
            lsum += nums[i];
            rsum = sum - lsum;
            int n1 = i + 1;
            int n2 = n - n1;

            long lavg = (lsum / n1);
            long ravg = (i == n - 1) ? 0 : (rsum / n2);
            int diff = (int) Math.abs(lavg - ravg);
            if (minAvg > diff) {
                minAvg = diff;
                minIndex = i;
            }
        }
        return minIndex;
    }
}