package Method;
import User.User;
import User.User.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CreateUserAccount {
    public void Create(){
        List<User> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tro ve menu: ");
        System.out.println("0. Yes");
        System.out.println("1. No");
        int isCountinue = scanner.nextInt();
        while (isCountinue == 1){
            System.out.println("Nhap vao Username: ");
            String userName = scanner.next();
            System.out.println("Nhap vao Firstname: ");
            String firstName = scanner.next();
            System.out.println("Nhap vao Lastname: ");
            String lastName = scanner.next();
            System.out.println("Nhap vao Password");
            String password = scanner.next();
            System.out.println("Xac nhan Password");
            String confirmPassword = scanner.next();
            System.out.println("Nhap vao Phone");
            String phone = scanner.next();
            System.out.println("Nhap vao Email");
            String email = scanner.next();
            User user = new User(userName,firstName,lastName,phone,email,password,confirmPassword);
        }
    }
}
