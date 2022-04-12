package Actions;

import java.util.*;

public class User {

    static Map<String, userDetails> data = new HashMap<>();
    static String username;

    public static void addDetails() {

        userDetails ud = new userDetails("naveen", "naveen");
        userDetails ud1 = new userDetails("praveen", "praveen");
        userDetails ud2 = new userDetails("kaveen", "kaveen");
        userDetails ud3 = new userDetails("john", "john");
        userDetails admin = new userDetails("Admin", "Admin@123");

        data.put("naveen", ud);
        data.put("praveen", ud1);
        data.put("kaveen", ud2);
        data.put("john", ud3);
        data.put("Admin", admin);

    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        addDetails();

        System.out.println("Enter user name");
        String name = sc.next();
        username = name;
        System.out.println("Enter password");
        String password = sc.next();

        if (data.containsKey(name)) {
            if (data.get(name).getPass().equals(password)) {
                if (name.equals("Admin")) {
                    Admin.action();
                } else {
                    System.out.println("Login Sucess");
                    userHome.home();
                }
            } else {
                System.out.println("Invalid password");
                login();
            }
        }

        else {
            System.out.println("Invalid username");
            System.out.println("1->signup");
            System.out.println("2->Try again");

            int n = sc.nextInt();

            if (n == 1) {
                signup();
            } else if (n == 2) {
                login();
            } else {
                System.out.println("Invalid ");
            }
        }

    }

    public void signup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String uname = sc.next();
        System.out.println("Enter password");
        String pass = sc.next();

        if (data.containsKey(uname)) {
            System.out.println("User name already exist");
            System.out.println("1->Forgot password..? else try again ");
            int ac = sc.nextInt();
            if (ac == 1) {
                System.out.println("Enter your username");
                String user = sc.next();
                System.out.println("Your password is" + data.get(user).getPass());
                login();
            } else
                login();
        } else {
            userDetails id = new userDetails(uname, pass);
            data.put(uname, id);
            userHome.home();
        }

    }
}