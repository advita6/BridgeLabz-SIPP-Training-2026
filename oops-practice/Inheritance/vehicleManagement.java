// Superclass
class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayBaseInfo() {
        System.out.println("Model: " + model + " | Top Speed: " + maxSpeed + " km/h");
    }
}

// Interface providing behavior
interface Refuelable {
    void refuel();
}

// Subclass 1: Standard Extension
class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        System.out.println(model + " is charging its battery...");
    }
}

// Subclass 2: Hybrid Structure (Extends Class & Implements Interface)
class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling at the gas station...");
    }
}

// Demonstration Class
public class VehicleSystem {
    public static void main(String[] args) {
        System.out.println("--- Electric Vehicle ---");
        ElectricVehicle ev = new ElectricVehicle("Tesla Model S", 250);
        ev.displayBaseInfo();
        ev.charge();

        System.out.println("\n--- Petrol Vehicle ---");
        PetrolVehicle pv = new PetrolVehicle("Ford Mustang", 260);
        pv.displayBaseInfo();
        pv.refuel();
    }
}