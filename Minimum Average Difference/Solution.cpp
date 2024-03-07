#include<bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int minimumAverageDifference(vector<int> &nums)
    {
        int n = nums.size();
        long long sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += nums[i];
        }
        int minIndex = -1;
        int minAvg = INT_MAX;

        long long lsum = 0, rsum = 0;

        for (int i = 0; i < n; i++)
        {
            lsum += nums[i];
            rsum = sum - lsum;
            int n1 = i + 1;
            int n2 = n - n1;

            long long lavg = (lsum / n1);
            long long ravg = (i == n - 1) ? 0 : (rsum / n2);
            int diff = abs(lavg - ravg);
            if (minAvg > diff)
            {
                minAvg = diff;
                minIndex = i;
            }
        }
        return minIndex;
    }
};