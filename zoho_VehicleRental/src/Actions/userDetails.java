package Actions;

import java.util.*;

public class userDetails {
    private String userName;
    private String password;
    private long phone;
    private int minDeposite;
    private static int vehicle = 0;

    static Scanner sc = new Scanner(System.in);

    public userDetails(String user, String pass) {
        userName = user;
        password = pass;
    }

    public void setName(String name) {
        userName = name;
    }

    public String getName() {
        return userName;
    }

    public void setPass(String pass) {
        password = pass;
    }

    public String getPass() {
        return password;
    }

    public void setPhone(long ph) {
        phone = ph;
    }

    public long getPhone() {
        return phone;
    }

    public void setDep(int amt) {
        if (amt < 3000) {
            System.out.println("Payment failed .... Minimun amount : 3000 for bike and 10000 for car");
        } else {
            System.out.println("Payment sucessfull");
            minDeposite = amt;
        }
    }

    public int getDep() {
        return minDeposite;
    }

    public void setVehicle(int vname) {
        vehicle = vname;
    }

    public int getVehicle() {
        return vehicle;
    }
}