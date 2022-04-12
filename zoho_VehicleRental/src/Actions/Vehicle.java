package Actions;

import java.util.*;

public class Vehicle {

    static Scanner sc = new Scanner(System.in);

    private String name;
    private int regNo;

    public String getName() {
        return name;
    }

    public void setName(String vehicleName) {
        name = vehicleName;
    }

    public int getNum() {
        return regNo;
    }

    public void setNum(int vehicleName) {
        regNo = vehicleName;
    }

    public void add() {

        System.out.println("1->Car");
        System.out.println("2->Bike");

        int n = sc.nextInt();

        if (n == 1) {
            Car c = new Car();
            c.add();
            ;
        } else if (n == 2) {
            Bike b = new Bike();
            b.add();
        } else {
            System.out.println("Invalid number");
            Admin.action();
        }
    }

    public static void modify() {

        System.out.println("1->Update details");
        System.out.println("2->Delete");
        int n = sc.nextInt();
        if (n == 1) {
            Vehicle v = new Vehicle();
            v.update();
        } else if (n == 2) {
            Vehicle v = new Vehicle();
            v.delete();
        } else {
            System.out.println("Invalid input");
            Admin.action();
        }
    }

    public void delete() {
        System.out.println("Enter vehicle type (1->car/2->bike)");
        int type = sc.nextInt();
        if (type == 2) {
            Bike b = new Bike();
            b.delete();
        } else if (type == 1) {
            Car c = new Car();
            c.delete();
        } else {
            System.out.println("Invalid input");
            Vehicle.modify();
        }
    }

    public void update() {
        int k = 0;
        System.out.println("Vehicle for service : ");
        for (Map.Entry<Integer, vehicleInfo> map : Main.vehiData.entrySet()) {
            int drip = map.getValue().getDrip();
            String ve = map.getValue().type;
            if ((ve.equals("car") && drip >= 3000) || (ve.equals("bike") && drip >= 1500)) {
                k = 1;
                System.out.println("Reg Num : " + map.getKey() + ", Name : " + map.getValue().getName() + ", Type : "+ map.getValue().type + ", kilometer ran after service : " + map.getValue().getDrip());
            }
        }
        if (k == 0) {
            System.out.println("No due vehicles");
        }
        System.out.println("1->Make service and refine it");
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("Enter the reg number : ");
            int due = sc.nextInt();
            Main.vehiData.get(due).setDrip(0);
            Main.vehiData.get(due).available = true;
            System.out.println("Successfully refined");
            Admin.action();
        } else {
            System.out.println("Invalid input");
            Admin.action();
        }
    }

    public static void dueDate() {
        int k = 0;
        System.out.println("Vehicle for service : ");
        for (Map.Entry<Integer, vehicleInfo> map : Main.vehiData.entrySet()) {
            int drip = map.getValue().getDrip();
            String ve = map.getValue().type;
            if ((ve.equals("car") && drip >= 3000) || (ve.equals("bike") && drip >= 1500)) {
                map.getValue().available = false;
                k = 1;
                System.out.println("Reg Num : " + map.getKey() + ", Name : " + map.getValue().getName() + ", Type : " + map.getValue().type + ", kilometer ran after service : " + map.getValue().getDrip());
            }
        }
        if (k == 0) {
            System.out.println("No due vehicles");
        }
        Admin.action();
    }

}