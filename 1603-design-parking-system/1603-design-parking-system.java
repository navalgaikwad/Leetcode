class ParkingSystem {

    // Number of empty slots for each type of car
    int[] empty;

    public ParkingSystem(int big, int medium, int small) {
        this.empty = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {

        // If space is available, allocate and return True
        if (this.empty[carType - 1] > 0) {
            this.empty[carType - 1]--;
            return true;
        }

        // Else, return False
        return false;
    }
}