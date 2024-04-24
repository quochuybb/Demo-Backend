import Method.CreateUserAccount;
import Method.CreateUserAccount.*;
import User.User.*;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning){
            System.out.println("User Management Program");
            System.out.println("1. Create user account");
            System.out.println("2. Check exist user");
            System.out.println("3. Search user");
            System.out.println("4. Update User");
            System.out.println("5. Save to file");
            System.out.println("6. Print all list from file");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    CreateUserAccount method = new CreateUserAccount();
                    method.Create();
                    break;
                case 7:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }
}