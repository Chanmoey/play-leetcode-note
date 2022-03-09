package LeetCode1603;

/**
 * @author Chanmoey
 * @date 2022年03月09日
 */
class ParkingSystem {

    int[] canPark;

    public ParkingSystem(int big, int medium, int small) {
        this.canPark = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return --this.canPark[carType - 1] >= 0;
    }
}

