package Method;

import User.User;

import java.io.*;
import java.lang.reflect.Field;

public class SaveToFile {
    File fileSave = new File("user.dat.txt");
    public void CreateFile(){
        if (!fileSave.exists()){
            try {
                fileSave.createNewFile();
                System.out.println("Tao file thanh cong");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void WriteTextToFile(User user){
        try {
            PrintWriter printWrite = new PrintWriter("user.dat.text","UTF-8");
            printWrite.println();
            printWrite.flush();
            printWrite.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
