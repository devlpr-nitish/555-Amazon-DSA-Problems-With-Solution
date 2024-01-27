#include <bits/stdc++.h>
using namespace std;

bool compareBoxes(vector<int> &box1, vector<int> &box2)
{
    return box1[1] > box2[1];
}

int maximumUnits(vector<vector<int>> &boxTypes, int truckSize)
{
    // Sort the boxTypes array based on the number of units per box in descending order
    sort(boxTypes.begin(), boxTypes.end(), compareBoxes);

    int maxUnits = 0;
    int remainingTruckSize = truckSize;

    for (vector<int> &boxType : boxTypes)
    {
        int numberOfBoxes = boxType[0];
        int numberOfUnitsPerBox = boxType[1];

        // Calculate the number of boxes to take considering the truck size
        int boxesToTake = min(remainingTruckSize, numberOfBoxes);

        // Update the remaining truck size
        remainingTruckSize -= boxesToTake;

        // Calculate the total units for the boxes taken
        maxUnits += boxesToTake * numberOfUnitsPerBox;

        // Break the loop if the truck is full
        if (remainingTruckSize == 0)
        {
            break;
        }
    }

    return maxUnits;
}
