class ParkingSystem
{
public:
    int big, medium, small;
    ParkingSystem(int b, int m, int s)
    {
        big = b;
        medium = m;
        small = s;
    }

    bool addCar(int carType)
    {
        if ((carType == 1 && big == 0) || (carType == 2 && medium == 0) || (carType == 3 && small == 0))
        {
            return false;
        }
        else
        {
            if (carType == 1)
            {
                big--;
            }
            else if (carType == 2)
            {
                medium--;
            }
            else if (carType == 3)
            {
                small--;
            }
            return true;
        }
    }
};

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem* obj = new ParkingSystem(big, medium, small);
 * bool param_1 = obj->addCar(carType);
 */