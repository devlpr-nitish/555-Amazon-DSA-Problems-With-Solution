#include<bits/stdc++.h>
using namespace std;

class Solution
{
public:
    char slowestKey(vector<int> &rt, string keypress)
    {
        int maxTime = rt[0];
        char result = keypress[0];

        for (int i = 1; i < rt.size(); i++)
        {
            int current = rt[i] - rt[i - 1];
            if (current > maxTime || current == maxTime && keypress[i] > result)
            {
                maxTime = current;
                result = keypress[i];
            }
        }

        return result;
    }
};