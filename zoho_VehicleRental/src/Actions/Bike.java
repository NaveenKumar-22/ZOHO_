package Actions;

import java.util.*;

public class Bike extends Vehicle {

    private final String type = "bike";
    static Scanner sc = new Scanner(System.in);

    public void add() {

        System.out.println("Enter the name of bike");
        setName(sc.next());

        System.out.println("Enter the reg Number");
        int rno = sc.nextInt();
        setNum(rno);

        vehicleInfo vi = new vehicleInfo(getName(), getNum(), "bike");

        Main.vehiData.put(vi.getNum(), vi);
        if (Main.vehiData.containsKey(rno)) {
            System.out.println("Added Successfully");
            for (Map.Entry<Integer, vehicleInfo> map : Main.vehiData.entrySet()) {
                System.out.println(map.getValue().type + " " + map.getKey() + " " + map.getValue().getName() + " "+ map.getValue().available);
            }
            System.out.println("1->Add More");
            System.out.println("2->Exit");
            int n = sc.nextInt();
            if (n == 1) {
                super.add();
            } else if (n == 2) {
                Admin.action();
            } else {
                System.out.println("Invalid input");
                Admin.action();
            }
        } else {
            System.out.println("Failed to add");
            System.out.println("1->Try again");
            System.out.println("2->Exit");
            int n = sc.nextInt();
            if (n == 1) {
                super.add();
            } else {
                Admin.action();
            }
        }
    }

    public void delete() {
        System.out.println("Enter register number");
        int n = sc.nextInt();
        if (Main.vehiData.containsKey(n)) {
            Main.vehiData.remove(n);
            System.out.println("Removed successfully");

            for (Map.Entry<Integer, vehicleInfo> map : Main.vehiData.entrySet()) {
                System.out.println(map.getValue().type + " " + map.getKey() + " " + map.getValue().getName() + " "+ map.getValue().available);
            }

            System.out.println("1->Remove More");
            System.out.println("2->Exit");

            int m = sc.nextInt();
            if (m == 1) {
                super.delete();
            } else if (n == 2) {
                Admin.action();
            } else {
                System.out.println("Invalid input");
                Admin.action();
            }

        }
    }

    public void select(int minDep) {
        if (minDep < 3000) {
            System.out.println("Low Security balance(Minimum amount :Car(10000) / Bike(3000)) " + minDep);
            System.out.println("1->Add Amount");
            int a = sc.nextInt();
            if (a == 1) {
                System.out.println("Enter payment Amount");
                int amt = sc.nextInt();
                int already = User.data.get(User.username).getDep();
                User.data.get(User.username).setDep(already + amt);
                userHome.select();
            } else {
                System.out.println("Invalid input");
                userHome.home();
            }
        } else if (Main.renters.contains(User.username)) {
            System.out.println("You can't take more than one vehicle");
            userHome.home();
        } else {
            System.out.println("Enter the register number of bike");
            int reg = sc.nextInt();

            System.out.println("Enter required date");
            String date = sc.next();

            Main.vehiData.get(reg).setDate(date);

            if (Main.vehiData.containsKey(reg) && Main.vehiData.get(reg).available) {

                System.out.println("Vehicle booked successfully");
                userHome.addRentersArrayList();
                User.data.get(User.username).setVehicle(reg);

                System.out.println("setted");
                Main.vehiData.get(reg).available = false;

                Main.vehiData.get(reg).setRenter(User.username);

                userHome.home();
            } else {
                System.out.println("Vehicle is unavailable , please select other");
                userHome.home();
            }
        }
    }
}