import Method.CreateUserAccount;
import Method.CreateUserAccount.*;
import Method.SaveToFile;
import User.User.*;
import Method.SaveToFile.*;

import java.lang.reflect.Method;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning){
            System.out.println("--------------------------------------");
            System.out.println("| User Management Program            |");
            System.out.println("| 1. Create user account             |");
            System.out.println("| 2. Check exist user                |");
            System.out.println("| 3. Search user                     |");
            System.out.println("| 4. Update User                     |");
            System.out.println("| 5. Save to file                    |");
            System.out.println("| 6. Print all list from file        |");
            System.out.println("| 7. Exit                            |");
            System.out.println("--------------------------------------");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    CreateUserAccount CreateUser = new CreateUserAccount();
                    CreateUser.Create();
                    break;
                case 5:
                    SaveToFile SaveFile = new SaveToFile();
                    SaveFile.CreateFile();
                    break;
                case 7:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Error");
            }
        }
    }
}