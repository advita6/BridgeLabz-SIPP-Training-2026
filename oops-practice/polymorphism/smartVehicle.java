abstract class Vehicle {
    String vehicleNumber, ownerName;

    Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    abstract double calculateToll();
}

class Car extends Vehicle {
    Car(String v, String o) {
        super(v, o);
    }

    double calculateToll() {
        return 100;
    }
}

class Bus extends Vehicle {
    Bus(String v, String o) {
        super(v, o);
    }

    double calculateToll() {
        return 250;
    }
}

class Truck extends Vehicle {
    Truck(String v, String o) {
        super(v, o);
    }

    double calculateToll() {
        return 400;
    }
}

public class Main {

    static double calculateTotalRevenue(Vehicle arr[]) {
        double sum = 0;
        for (Vehicle v : arr)
            sum += v.calculateToll();
        return sum;
    }

    static void searchVehicle(Vehicle arr[], String num) {
        for (Vehicle v : arr)
            if (v.vehicleNumber.equals(num)) {
                System.out.println(v.ownerName);
                return;
            }
        System.out.println("Not Found");
    }

    public static void main(String args[]) {

        Vehicle arr[] = {
                new Car("C101", "Rahul"),
                new Bus("B201", "Amit"),
                new Truck("T301", "Riya"),
                new Car("C102", "Neha")
        };

        System.out.println("Revenue = " + calculateTotalRevenue(arr));

        searchVehicle(arr, "T301");

        Vehicle max = arr[0];

        int car = 0, bus = 0, truck = 0;

        for (Vehicle v : arr) {

            if (v.calculateToll() > max.calculateToll())
                max = v;

            if (v instanceof Car)
                car++;
            else if (v instanceof Bus)
                bus++;
            else
                truck++;
        }

        System.out.println("Highest Toll : " + max.vehicleNumber);
        System.out.println("Cars=" + car + " Buses=" + bus + " Trucks=" + truck);
    }
}