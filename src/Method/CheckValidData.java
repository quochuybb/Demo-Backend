package Method;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckValidData {
    public boolean CheckFormatData(String string, int index){
        if (CheckLength(string,index)){
            for (int i = 0; i < string.length() ; i++){
                if (string.charAt(i) == ' '){
                    if (index == 5){
                        System.out.println("Loi Username co khoang trang");
                    }
                    else if (index == 6){
                        System.out.println("Loi Password co khoang trang");
                    }
                    else {
                        System.out.println("Loi Phone number co khoang trang");
                    }
                    return false;
                }
            }
            return true;
        }
        if (index == 5){
            System.out.println("Loi Username khong du 5 ki tu");
        }
        else if (index == 6){
            System.out.println("Loi Password khong du 6 ki tu");
        }
        else {
            System.out.println("Loi Phone number khong du 10 so");
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
        System.out.println("Loi mat khau khong dung");
        return false;
    }
    public boolean CheckEmail(String email){
        String regex = "^[a-zA-Z]+[a-z0-9]*@gmail.com";
        Pattern pattern =  Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()){
            return true;
        }
        System.out.println("Loi email khong dung format");
        return false;
    }
    public boolean CheckError(String userName, String phone, String email, String password, String confirmPassword){
        if (CheckEmail(email) && CheckConfirmPassword(password,confirmPassword) && CheckFormatData(userName,5) && CheckFormatData(password,6) && CheckFormatData(phone,10)){
            return true;
        }
        return false;
    }
}
