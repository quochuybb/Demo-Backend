package Method;
import User.User;
import User.User.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateUserAccount {
    public List<User> list = new ArrayList<>();
    public void Create(int root){
        String regex = "^[a-zA-Z]";
        Pattern pattern =  Pattern.compile(regex);
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        String isCountinue = "N";
        while (isCountinue.equals("N") || isCountinue.equals("n")){
            try {
                System.out.println("Input Username: ");
                String userName = scanner.nextLine();
                System.out.println("Input Firstname: ");
                String firstName = scanner.nextLine();
                if (!pattern.matcher(firstName).find()){
                    System.out.println("Error Firstname have number");
                    break;
                }
                System.out.println("Input Lastname: ");
                String lastName = scanner.nextLine();
                if (!pattern.matcher(lastName).find()){
                    System.out.println("Error Lastname have number");
                    break;
                }
                System.out.println("Input Password");
                String password = scanner.nextLine();
                System.out.println("Confirm Password");
                String confirmPassword = scanner.nextLine();
                System.out.println("Input Phone");
                String phone = scanner.nextLine();
                System.out.println("Input Email");
                String email = scanner.nextLine();
                User user = new User(userName,firstName,lastName,phone,email,password,confirmPassword);
                list.add(user);
                if (root == 1){
                    while (isCountinue.equals("Y") || isCountinue.equals("y") || isCountinue.equals("N") || isCountinue.equals("n")){
                        System.out.println("Back to menu: ");
                        System.out.println("Y/N");
                        isCountinue = scanner.nextLine();
                        if (isCountinue.equals("Y") || isCountinue.equals("y") || isCountinue.equals("N") || isCountinue.equals("n")){
                            break;
                        }
                    }
                }
            }
            catch (Exception e){
                System.out.println("Error input");
            }

        }
    }
}
