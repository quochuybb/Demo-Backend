import Method.CreateUserAccount;
import Method.ActiveWithFile;
import User.User;

import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String input;
        CreateUserAccount CreateUser = new CreateUserAccount();
        ActiveWithFile activeWithFile = new ActiveWithFile();
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning){
            try {
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
                input = scanner.next();
                int choice = Integer.parseInt(input);
                switch (choice){
                    case 1:
                        CreateUser.Create(1);
                        break;
                    case 2:
                        System.out.println("Enter Username:");
                        input = scanner.next();
                        if (activeWithFile.CheckExist(input)){
                            System.out.println("Exist User");
                        }
                        else {
                            System.out.println("No User Found!");
                        }
                        break;
                    case 3:
                        activeWithFile.FindInfo();
                        break;
                    case 4:
                        System.out.println("Enter Username:");
                        choice = scanner.nextInt();
                        if (choice == 1){
                            System.out.println("Enter Username:");
                            input = scanner.next();
                            activeWithFile.UpdateInfo(input);
                        }
                        else if (choice == 2){
                            System.out.println("Enter Username:");
                            input = scanner.next();
                            activeWithFile.DeleteInfo(input);
                        }
                        break;
                    case 5:
                        for (int i = 0 ; i < CreateUser.list.size(); i++){
                            List<String> line = new ArrayList<>();
                            line.add(CreateUser.list.get(i).getUserName());
                            line.add(CreateUser.list.get(i).getFirstName());
                            line.add(CreateUser.list.get(i).getLastName());
                            line.add(CreateUser.list.get(i).getEmail());
                            line.add(CreateUser.list.get(i).getPhone());
                            String pass = hashInfo(CreateUser.list.get(i).getPassword());
                            line.add(pass);
                            activeWithFile.WriteTextToFile(line);
                        }
                        break;
                    case 6:
                        activeWithFile.ReadListFromFile();
                        break;
                    case 7:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Error");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage() + ". You must enter integer");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    public static String hashInfo(String info){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(info.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}