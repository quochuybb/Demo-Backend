package Method;

import User.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class ActiveWithFile {
    CreateUserAccount createUserAccount = new CreateUserAccount();
    String line;
    public ActiveWithFile() throws FileNotFoundException {
    }

    public void WriteTextToFile(List<String> line){
        if (CheckExist(line.get(0))){
            for (int i =0 ; i < line.size(); i++){
                try {
                    FileWriter printWrite = new FileWriter("user.dat", true);
                    if (i == line.size() - 1){
                        printWrite.write(line.get(i) + "\n");
                    }
                    else {
                        printWrite.write(line.get(i) + " - ");
                    }
                    printWrite.flush();
                    printWrite.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        else {
            System.out.println("User " + line.get(0) + " exist!!!");
        }


    }
    public boolean CheckExist(String userName){
        boolean isFound = false;
        try {
            FileReader fileReader = new FileReader("user.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                String[] parts = line.split(" - ");
                if (userName.equals(parts[0])){
                    isFound = true;
                    break;
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  isFound;
    }
    public void FindInfo(){
        try {
            FileReader fileReader = new FileReader("user.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println("Enter Fistname or Lastname:");
            Scanner scanner = new Scanner(System.in);
            String Name = scanner.next();
            while ((line = bufferedReader.readLine()) != null){
                String[] parts = line.split(" - ");
                if (parts[1].contains(Name) || parts[2].contains(Name)){
                    System.out.println(line);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void UpdateInfo(String userName){
        DeleteInfo(userName);
        createUserAccount.Create(2);
        for (int i = 0 ; i < createUserAccount.list.size(); i++){
            List<String> line = new ArrayList<>();
            line.add(createUserAccount.list.get(i).getUserName());
            line.add(createUserAccount.list.get(i).getFirstName());
            line.add(createUserAccount.list.get(i).getLastName());
            line.add(createUserAccount.list.get(i).getEmail());
            line.add(createUserAccount.list.get(i).getPhone());
            line.add(createUserAccount.list.get(i).getPassword());
            line.add(createUserAccount.list.get(i).getConfirmPassword());
            WriteTextToFile(line);
        }
    }
    public void DeleteInfo(String userName){
        List<List<String>> lines = new ArrayList<>();
        if (!CheckExist(userName)){
            System.out.println("Username does not exist");
            return;
        }
        try {
            FileReader fileReader = new FileReader("user.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                String[] parts = line.split(" - ");
                if (userName.equals(parts[0])){
                    continue;
                }
                List<String> newparts =  Arrays.asList(parts);
                lines.add(newparts);
            }
            FileWriter clearFile = new FileWriter("user.dat", false);
            clearFile.flush();
            clearFile.close();
            for (int i = 0;i < lines.size();i++){
                WriteTextToFile(lines.get(i));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void ReadListFromFile(){
        try {
            FileReader fileReader = new FileReader("user.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
