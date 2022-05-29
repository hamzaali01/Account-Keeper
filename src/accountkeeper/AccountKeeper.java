/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountkeeper;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
/**
 *
 * @author HP
 */
public class AccountKeeper {
 private String ID;
 private String password;
 private String[] names = new String[40];
 private String[] websites;
 private int i=0;   
 private int count = 0;
    public AccountKeeper(String Website){
        if(Website==null || "".equals(Website)){
            Website = " ";
        }
        Website = Website.toUpperCase();
    try{
    File file = new File("E:/webinfo.txt");
    Scanner myReader = new Scanner(file);
    while (myReader.hasNextLine()) 
             {
                 String data = myReader.nextLine();
                 if(count==0){
                 names[i] = data;
                 i++;
                 }
                  count++;
                  if(count==4)
                      count=0;
                 data = data.toUpperCase();
                 if(data.equals(Website)){
                     ID = myReader.nextLine();
                     password = myReader.nextLine();
                 }
    }
    }
     catch (FileNotFoundException e) {
             System.out.println("File not found.");
             e.printStackTrace();
         }
    }
    
    public String getID(){
    return ID;
    }
    public String getPassword(){
     return password;   
    }
   public String[] getWebsites(){
    websites = clearUnusedSpace(names);
    return websites;
    }
   public String[] clearUnusedSpace(String[] names){
        int j=0;
        for(int i=0; i<names.length;i++){
            if(names[i]!=null){
              j++;
            }
        }
        websites = new String[j];
        for(int i=0; i<names.length;i++){
            if(names[i]!=null){
              websites[i] = names[i];
            }
        }  
        return websites;
   }
    
}
