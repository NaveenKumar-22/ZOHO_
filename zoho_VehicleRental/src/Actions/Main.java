package Actions;

import java.util.*;

public class Main {
    static Map<Integer, vehicleInfo> vehiData = new LinkedHashMap<>();
    static ArrayList<String> renters = new ArrayList<>();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        vehicleInfo v1 = new vehicleInfo("mt-15", 1230, "bike");
        vehicleInfo v2 = new vehicleInfo("mt-15", 1231, "bike");
        vehicleInfo v3 = new vehicleInfo("mt-15", 1232, "bike");
        vehicleInfo v4 = new vehicleInfo("mt-15", 1233, "bike");
        vehicleInfo v5 = new vehicleInfo("rx-100", 1234, "bike");
        vehicleInfo v6 = new vehicleInfo("rx-100", 1235, "bike");
        vehicleInfo v7 = new vehicleInfo("rx-100", 1236, "bike");
        vehicleInfo v8 = new vehicleInfo("rx-100", 1237, "bike");
        vehicleInfo v9 = new vehicleInfo("rx-100", 1238, "bike");

        vehiData.put(1230, v1);
        vehiData.put(1231, v2);
        vehiData.put(1232, v3);
        vehiData.put(1233, v4);
        vehiData.put(1234, v5);
        vehiData.put(1235, v6);
        vehiData.put(1236, v7);
        vehiData.put(1237, v8);
        vehiData.put(1238, v9);

        vehiData.get(1234).setDrip(1700);

        vehicleInfo c5 = new vehicleInfo("Ciaz", 2345, "car");
        vehicleInfo c6 = new vehicleInfo("Swift", 2346, "car");
        vehicleInfo c7 = new vehicleInfo("Indica", 2347, "car");
        vehicleInfo c8 = new vehicleInfo("Innova", 2348, "car");
        vehicleInfo c9 = new vehicleInfo("Ertiga", 2349, "car");

        vehiData.put(2345, c5);
        vehiData.put(2346, c6);
        vehiData.put(2347, c7);
        vehiData.put(2348, c8);
        vehiData.put(2349, c9);

        vehiData.get(2348).setDrip(3120);

        User user = new User();

        System.out.println("Welcome");
        System.out.println("1->Admin");
        System.out.println("2->User Login");
        System.out.println("3->User signup");

        int n = sc.nextInt();
        if (n == 1) {
            user.login();
        } else if (n == 2) {
            user.login();
        } else if (n == 3) {
            user.signup();
        } else {
            System.out.println("Invalid input");
        }
    }
}