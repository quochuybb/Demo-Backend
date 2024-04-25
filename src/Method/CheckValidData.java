package Method;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckValidData {
    public boolean CheckFormatData(String string, int index){
        if (CheckLength(string,index)){
            for (int i = 0; i < string.length() ; i++){
                if (string.charAt(i) == ' '){
                    if (index == 5){
                        System.out.println("Error Username has spaces");
                    }
                    else if (index == 6){
                        System.out.println("Error Password has spaces");
                    }
                    else {
                        System.out.println("Error Phone has spaces");
                    }
                    return false;
                }
            }
            return true;
        }
        if (index == 5){
            System.out.println("Username hasn't to be at least five characters");
        }
        else if (index == 6){
            System.out.println("Password hasn't to be at least 6 characters");
        }
        else {
            System.out.println("Phone hasn't to be at least ten characters");
        }
        return false;
    }
    public boolean CheckLength(String string, int index){
        if (string.length() >= index){
            return true;
        }
        return false;
    }
    public boolean CheckConfirmPassword(String password, String confirmPassword){
        if (password.equals(confirmPassword)){
            return true;
        }
        System.out.println("Error of incorrect password");
        return false;
    }
    public boolean CheckEmail(String email){
        String regex = "^[a-zA-Z]+[a-z0-9]*@gmail.com";
        Pattern pattern =  Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()){
            return true;
        }
        System.out.println("Error of incorrect email format");
        return false;
    }
    public boolean CheckError(String userName, String phone, String email, String password, String confirmPassword){
        if (CheckEmail(email) && CheckConfirmPassword(password,confirmPassword) && CheckFormatData(userName,5) && CheckFormatData(password,6) && CheckFormatData(phone,10)){
            return true;
        }
        return false;
    }
}
