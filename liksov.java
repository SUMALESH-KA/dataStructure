import java.util.*;

interface Vehicle {
    int getNumberOfWheels();
}

// Separate interface for vehicles with engines
interface EngineVehicle extends Vehicle {
    void startEngine();
}

// Car class implements EngineVehicle
class Car implements EngineVehicle {
    public int getNumberOfWheels() {
        return 4;
    }

    public void startEngine() {
        System.out.println("Car engine started");
    }
}

// MotorCycle class implements EngineVehicle
class MotorCycle implements EngineVehicle {
    public int getNumberOfWheels() {
        return 2;
    }

    public void startEngine() {
        System.out.println("Motorcycle engine started");
    }
}

// Bicycle class implements only Vehicle (no engine)
class Bicycle implements Vehicle {
    public int getNumberOfWheels() {
        return 2;
    }
}

public class liksov {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(new MotorCycle()); // Valid (LSP satisfied)
        vehicleList.add(new Car());        // Valid (LSP satisfied)
        vehicleList.add(new Bicycle());    // Valid (LSP satisfied)

        // Display the number of wheels for each vehicle
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.getNumberOfWheels());
        }
    }
}
