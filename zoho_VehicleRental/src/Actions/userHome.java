package Actions;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class userHome {
    static Scanner sc = new Scanner(System.in);
    static User u = new User();

    public static void home() {
        System.out.println("Welcome Home");
        System.out.println("1->View vehicles");
        System.out.println("2->Book vehicle");
        System.out.println("3->View cart");
        System.out.println("4->Return vehicle");
        System.out.println("5->Exit");
        int n = sc.nextInt();
        if (n == 1) {
            for (Map.Entry<Integer, vehicleInfo> map : Main.vehiData.entrySet()) {
                System.out.println("Reg Num : " + map.getKey() + ", Name : " + map.getValue().getName()
                        + ", Availablity : " + map.getValue().available);
            }
            System.out.println("2->Book");
            System.out.println("3->Exit");
            n = sc.nextInt();
            if (n == 2)
                select();
            else if (n == 3)
                u.login();
            else {
                System.out.println("Invalid input");
                home();
            }

        } else if (n == 2) {
            select();
        } else if (n == 3) {

            String un = User.username;
            int reg = User.data.get(un).getVehicle();
            System.out.println("Welcome " + un);
            System.out.println();
            System.out.println("Vehicle name : " + Main.vehiData.get(reg).getName() + ", Reg num : "
                    + Main.vehiData.get(reg).getNum());

            System.out.println("1->Exit");
            int action = sc.nextInt();
            if (action == 1)
                u.login();
            else {
                System.out.println("Invalid input");
                home();
            }
        } else if (n == 4) {
            retForm();
        } else if (n == 5) {
            u.login();
        } else {
            System.out.println("Invalid input");
            home();
        }
    }

    public static void addRentersArrayList() {
        String username = User.username;
        Main.renters.add(username);
    }

    public static void select() {
        int minDep = User.data.get(User.username).getDep();
        System.out.println("Security deposite : " + minDep);

        System.out.println("1->Car");
        System.out.println("2->Bike");
        int type = sc.nextInt();

        if (type == 1) {
            Car c = new Car();
            c.select(minDep);
        } else if (type == 2) {
            Bike b = new Bike();
            b.select(minDep);
        } else {
            System.out.println("Invalid input");
            select();
        }

    }

    public static void retForm() {

        int rent = 0;
        int reg = User.data.get(User.username).getVehicle();
        String veh = Main.vehiData.get(reg).getName();
        if (veh.equals("car"))
            rent = 2000;
        else
            rent = 1000;

        int secBal = User.data.get(User.username).getDep();

        System.out.println("Enter today's date (2021-05-12)");
        String date = sc.next();
        System.out.println("Enter current km");
        int km = sc.nextInt();
        System.out.println("Car damage(low/high/medium/none)");
        String damage = sc.next();
        int fine = generateFine(date, km, damage);
        System.out.println("Your Fine = " + fine + ", Total amount = " + (fine + rent));
        System.out.println("Enter mode of payment(1->safteyDeposite/2->cash)");
        int mode = sc.nextInt();
        if (mode == 1) {
            int depAmt = User.data.get(User.username).getDep();
            User.data.get(User.username).setDep(0);
            System.out.println("Hey Collect your remaining cash : " + (secBal - (fine + rent)));
            home();
        } else if (mode == 2) {
            System.out.println("cash Received ..your saftey balance will deposite in your account within 2 days");
            home();
        }
    }

    public static int generateFine(String date, int km, String damage) {

        int rent = 0;
        int fine = 0;
        int reg = User.data.get(User.username).getVehicle();
        String veh = Main.vehiData.get(reg).getName();
        if (veh.equals("car"))
            rent = 2000;
        else
            rent = 1000;

        String date1 = Main.vehiData.get(reg).getDate();

        LocalDate dateBefore = LocalDate.parse(date1);
        LocalDate dateAfter = LocalDate.parse(date);
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        int prevKm = Main.vehiData.get(reg).getKm();
        int diff = km - prevKm;

        Main.vehiData.get(reg).setDrip(km);

        if (noOfDaysBetween > 1) {
            fine = fine + 1500;
        }
        if (diff > 500) {
            fine = fine + 1000;
        }
        if (damage.equals("high")) {
            int tem = (rent / 100) * 75;
            fine = fine + tem;
        } 
        else if (damage.equals("low")) {
            int tem = (rent / 100) * 20;
            fine = fine + tem;
        }
         else if (damage.equals("medium")) {
            int tem = (rent / 100) * 50;
            fine = fine + tem;
        } 
        else if (damage.equals("none")) {
            fine = fine;
        } 
        else {
            System.out.println("Invalid input");
            retForm();
        }

        return fine;
    }
}