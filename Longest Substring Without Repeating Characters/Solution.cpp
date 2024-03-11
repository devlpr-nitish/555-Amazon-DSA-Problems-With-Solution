#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        unordered_map<char, int> map;
        int maxLen = 0;
        int n = s.length();
        int left = 0;
        int right = 0;
        while (right < n)
        {
            if (map.count(s[right]))
            {
                left = max(map[s[right]] + 1, left);
            }
            map[s[right]] = right;
            maxLen = max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
};