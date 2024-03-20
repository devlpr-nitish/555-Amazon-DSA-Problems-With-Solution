#include<bits/stdc++.h>
using namespace std;

class Solution
{
public:
    string convert(string s, int numRows)
    {
        if (numRows == 1)
        {
            return s;
        }

        string sb = "";

        for (int i = 0; i < numRows; i++)
        {
            int index = i;
            int deltDown = 2 * (numRows - 1 - i);
            int deltUp = 2 * i;
            bool goingDown = true;

            while (index < s.length())
            {
                sb += s[index];

                if (i == 0)
                {
                    index += deltDown;
                }
                else if (i == numRows - 1)
                {
                    index += deltUp;
                }
                else
                {
                    if (goingDown)
                    {
                        index += deltDown;
                    }
                    else
                    {
                        index += deltUp;
                    }
                    goingDown = !goingDown;
                }
            }
        }
        return sb;
    }
};