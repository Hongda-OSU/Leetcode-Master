class ParkingSystem {
    private int[] size;
    
    public ParkingSystem(int big, int medium, int small) {
        size = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // --> 0 means i>0 and i--
        return size[carType - 1] --> 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */