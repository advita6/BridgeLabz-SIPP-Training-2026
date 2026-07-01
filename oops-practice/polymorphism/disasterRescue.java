abstract class RescueTeam {

    String teamId;
    String location;

    RescueTeam(String id, String loc) {
        teamId = id;
        location = loc;
    }

    abstract void performDuty();
}

class MedicalTeam extends RescueTeam {

    MedicalTeam(String id, String loc) {
        super(id, loc);
    }

    void performDuty() {
        System.out.println("Medical Aid");
    }
}

class FireRescueTeam extends RescueTeam {

    FireRescueTeam(String id, String loc) {
        super(id, loc);
    }

    void performDuty() {
        System.out.println("Fire Rescue");
    }
}

class FoodSupplyTeam extends RescueTeam {

    FoodSupplyTeam(String id, String loc) {
        super(id, loc);
    }

    void performDuty() {
        System.out.println("Food Supply");
    }
}

public class Main {

    static void findTeamByLocation(RescueTeam arr[], String loc) {
        for (RescueTeam r : arr)
            if (r.location.equalsIgnoreCase(loc))
                System.out.println(r.teamId);
    }

    static void displayTeamsByPrefix(RescueTeam arr[], String pre) {
        for (RescueTeam r : arr)
            if (r.teamId.startsWith(pre))
                System.out.println(r.teamId);
    }

    public static void main(String args[]) {

        RescueTeam arr[] = {
                new MedicalTeam("M101", "Delhi"),
                new FireRescueTeam("F201", "Noida"),
                new FoodSupplyTeam("FS301", "Delhi"),
                new MedicalTeam("M102", "Agra")
        };

        for (RescueTeam r : arr)
            r.performDuty();

        findTeamByLocation(arr, "Delhi");

        displayTeamsByPrefix(arr, "M");

        int med = 0, fire = 0, food = 0;

        for (RescueTeam r : arr) {
            if (r instanceof MedicalTeam)
                med++;
            else if (r instanceof FireRescueTeam)
                fire++;
            else
                food++;
        }

        System.out.println("Medical=" + med);
        System.out.println("Fire=" + fire);
        System.out.println("Food=" + food);

        if (med >= fire && med >= food)
            System.out.println("MedicalTeam");
        else if (fire >= med && fire >= food)
            System.out.println("FireRescueTeam");
        else
            System.out.println("FoodSupplyTeam");
    }
}