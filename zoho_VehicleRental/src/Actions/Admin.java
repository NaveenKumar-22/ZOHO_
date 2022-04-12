package Actions;

import java.util.*;

public class Admin {
    static Scanner sc = new Scanner(System.in);

    public static void action() {

        System.out.println("1->view vehicles");
        System.out.println("2->Add vehicle");
        System.out.println("3->Modify details");
        System.out.println("4->Search vehicle");
        System.out.println("5->View vehicle due");
        System.out.println("6->Exit");

        int activity = sc.nextInt();

        Vehicle v = new Vehicle();

        if (activity == 1) {
            for (Map.Entry<Integer, vehicleInfo> map : Main.vehiData.entrySet()) {
                System.out.println("Reg Num : " + map.getKey() + ", Name : " + map.getValue().getName());
            }
            action();
        } 
        else if (activity == 2) {
            v.add();
        } 
        else if (activity == 3) {
            v.modify();
        } 
        else if (activity == 4) {
            search();
        } 
        else if (activity == 5) {
            Vehicle.dueDate();
        } 
        else if (activity == 6) {
            User u = new User();
            u.login();
        } 
        else {
            System.out.println("Invalid input");
            action();
        }
    }

    public static void search() {
        System.out.println("1->search by vehicle name");
        System.out.println("2->search by reg number");
        System.out.println("3->Exit");
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("Enter name to search");
            String reg = sc.next();
            int k = 0;
            for (Map.Entry<Integer, vehicleInfo> map : Main.vehiData.entrySet()) {
                if (reg.equals(map.getValue().getName())) {
                    System.out.println("Reg Num : " + map.getKey() + ", Name : " + map.getValue().getName());
                    k = 1;
                }
            }
            if (k == 0) {
                System.out.println("No item found");
                Admin.search();
            } else {
                Admin.search();
            }
        } else if (n == 2) {
            System.out.println("Enter reg num to search");
            int reg = sc.nextInt();
            int k = 0;
            for (Map.Entry<Integer, vehicleInfo> map : Main.vehiData.entrySet()) {
                if (reg == map.getKey()) {
                    System.out.println("Reg Num : " + map.getKey() + ", Name : " + map.getValue().getName());
                    k = 1;
                }
            }
            if (k == 0) {
                System.out.println("No item found");
                Admin.search();
            } else
            {
                Admin.search();
            }
        } 
        else if (n == 3) {
            Admin.action();
        }
        else {
            System.out.println("Invalid user action");
            Admin.search();
        }
    }
}