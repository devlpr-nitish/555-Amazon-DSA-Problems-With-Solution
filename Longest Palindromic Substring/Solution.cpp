#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int temp[1001][1001];
    string longestPalindrome(string s)
    {
        int n = s.length();
        int maxLen = INT_MIN;
        memset(temp, -1, sizeof(temp));
        int start = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                if (isPalindrome(i, j, s) == true)
                {
                    if (j - i + 1 > maxLen)
                    {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }

        return s.substr(start, maxLen);
    }

    bool isPalindrome(int i, int j, string &s)
    {
        if (i >= j)
        {
            return 1;
        }
        if (temp[i][j] != -1)
        {
            return temp[i][j];
        }
        if (s[i] == s[j])
        {
            return temp[i][j] = isPalindrome(i + 1, j - 1, s);
        }
        else
        {
            return temp[i][j] = 0;
        }
    }
};