import java.util.*;

public class MUOT {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> -a[1]));

        int maxUnits = 0;
        int remainingTruckSize = truckSize;

        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int numberOfUnitsPerBox = boxType[1];

            // Calculate the number of boxes to take considering the truck size
            int boxesToTake = Math.min(remainingTruckSize, numberOfBoxes);

            // Update the remaining truck size
            remainingTruckSize -= boxesToTake;

            // Calculate the total units for the boxes taken
            maxUnits += boxesToTake * numberOfUnitsPerBox;

            // Break the loop if the truck is full
            if (remainingTruckSize == 0) {
                break;
            }
        }

        return maxUnits;
    }
}
