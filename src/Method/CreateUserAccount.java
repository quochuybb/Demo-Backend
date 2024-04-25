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
    public void Create(){
        String regex = "^[a-zA-Z]";
        Pattern pattern =  Pattern.compile(regex);
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        int isCountinue = 1;
        while (isCountinue == 1){
            try {
                System.out.println("Input Username: ");
                String userName = scanner.next();
                System.out.println("Input Firstname: ");
                String firstName = scanner.next();
                if (!pattern.matcher(firstName).find()){
                    System.out.println("Error Firstname have number");
                    break;
                }
                System.out.println("Input Lastname: ");
                String lastName = scanner.next();
                if (!pattern.matcher(lastName).find()){
                    System.out.println("Error Lastname have number");
                    break;
                }
                System.out.println("Input Password");
                String password = scanner.next();
                System.out.println("Input Password");
                String confirmPassword = scanner.next();
                System.out.println("Input Phone");
                String phone = scanner.next();
                System.out.println("Input Email");
                String email = scanner.next();
                User user = new User(userName,firstName,lastName,phone,email,password,confirmPassword);
                list.add(user);
                System.out.println("Back to menu: ");
                System.out.println("0. Yes");
                System.out.println("1. No");
                isCountinue = scanner.nextInt();
            }
            catch (Exception e){
                System.out.println("Error input");
            }

        }
    }
}
