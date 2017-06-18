//โปรแกรมบันทึกข้อมูล
package web.ject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class ject {

    public static void main(String[] args) throws IOException {
        
        System.out.print("Program" + "\n"+"\n"); 
                
        Admin a = new Admin();
        a.Admin();     
    }   
}

class Admin{
    String name , userName , password ;

    void Admin() throws IOException{  
        
        Menu b = new Menu();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("name = ");
        name = scanner.next();
        System.out.print("username = ");
        userName = scanner.next();
        System.out.print("password = ");
        password = scanner.next();
        
          
        if (userName.equals("admin") && password.equals("admin")){
            System.out.println("\n"+"Hi "+name+" <> "+" Yousucess"+"\n");b.Menu();
            
        }else if(userName.equals("admin") && password.equals("password")){
            System.out.println("\n"+"Hi "+name+ " <> "+" Yousucess"+"\n");b.Menu();
            
        }else{ 
            System.out.println("\n"+"Username or Password"+"Wrong"+"\n"+"please try again"+"\n");
        
        } 
    }
}

class Menu{
    
    void Menu() throws IOException{
        
        Case c = new Case();       
        int i = 0;
        
        System.out.println("1.Add Data"+"\n"+"2.Check Data new"+"\n"+"3.Check Data All"
                +"\n"+"4.Contact"+"\n"+"5.exit"+"\n");
        
        Scanner scanner = new Scanner(System.in);
        int menu;
        do{
        System.out.print("Please select the menu : ");        
        menu = scanner.nextInt();

        switch (menu) {                                    
            case 1 : { c.Case1(); } break;
            case 2 : { c.Case2(); } break;
            case 3 : { c.Case3(); } break;          
            case 4 : { c.Case4(); } break;
 
        } System.out.println("\n"+"Thank You"+"\n");        
        }while(menu < 5);          
    }
}

class Case{
    
    String data1;
    
    void Case1() throws IOException{
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n"+"Please type the Data : ");
        data1 = scanner.next();
        System.out.println("\n"+"Complete");
                      
        File file = new File ("data.txt");
            if (!file.exists()){
                file.createNewFile();
            }       
        try (FileWriter writer = new FileWriter("data.txt",true)) {           
                writer.write(data1 + "\n");
                }catch (IOException e){
                         System.out.print(e);}               
}
        
    void Case2() throws FileNotFoundException{
        
        try{
        File file = new File ("data.txt");
        Scanner checkFile = new Scanner(file);
        
        String keep = checkFile.nextLine();
        System.out.println(keep);
        }catch (Exception e){}
        System.out.println("\n"+"Complete");       
    
}

    void Case3() throws FileNotFoundException{
        
        try{
            
        String [] arrayData = new String[1000];
        int count = 0;    
        File file = new File ("data.txt");
        Scanner checkFile = new Scanner(file);
        
        while (checkFile.hasNextLine()){
            arrayData [count] = checkFile.nextLine();
            count ++;
        }for(int i = 0; i < count; i++){
                System.out.println("\n"+arrayData[i]);
        }
        }catch (Exception e){}
        System.out.println("\n"+"Complete");  
    }
    
    void Case4(){
        
        System.out.print("please contact nona");
        
    }
    
}  