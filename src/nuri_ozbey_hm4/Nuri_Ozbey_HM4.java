/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuri_ozbey_hm4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 *
 * @author nurio
 */
public class Nuri_Ozbey_HM4 {
   
    /**
     */
    public static MyhashF myhash;
    public static void main(String[] args) {
        // TODO code application logic here
        myhash = new MyhashF();
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("<Command Line>:" );
            String myInput;
            myInput = input.nextLine();
            //System.out.println(myInput);
            int res = myCommand(myInput);
            if (res == 1) {
                break;
            }
        }
    }
    public static int myCommand(String myString) {
        String[] parsedInput = myString.split(" ");
        if((parsedInput[0].charAt(0) == 'X' || parsedInput[0].charAt(0) == 'x')&& parsedInput[0].length() <= 1){
            System.out.println("Program Closing... ");
            System.out.println("Have a good day :)");
            return 1;
        }else if((parsedInput[0].charAt(0) == 'R' || parsedInput[0].charAt(0) == 'r')&& parsedInput.length >= 2){
            try {
                // Open the file that is the first 
                // command line parameter
                //FileInputStream fstream = new FileInputStream("C:\\Users\\nurio\\Desktop\\asd.txt");
                FileInputStream fstream = new FileInputStream(parsedInput[1]);
                // Get the object of DataInputStream
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;
                //Read File Line By Line
                while ((strLine = br.readLine()) != null) {
                    // Print the content on the console
                    //System.out.println(strLine);
                    int res = myCommand(strLine);
                    if (res == 1) {
                        return 1;
                    }
                }
                //Close the input stream
            } catch (IOException e) {//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
        }else if((parsedInput[0].charAt(0) == 'I' || parsedInput[0].charAt(0) == 'i')&& parsedInput.length >= 2){
            myhash.Insert(parsedInput[1]);
            //System.out.println("Person "+parsedInput[1]+" registered");//Kaldır
        }else if((parsedInput[0].charAt(0) == 'F' || parsedInput[0].charAt(0) == 'f')&& parsedInput.length >= 2){
            //ystem.out.println(parsedInput.length);
            if(parsedInput.length > 1){
                if(parsedInput.length > 2){
                    myhash.Friend(parsedInput[1],parsedInput[2]);
                    //System.out.println("Person ["+parsedInput[1]+"] and ["+parsedInput[2]+"] are friends");//kaldır
                }else{
                    System.out.println("[ERROR] Second person can not be blank..!");
                }
            }else{
                System.out.println("[ERROR] First person can not be blank..!");
            }
        }else if((parsedInput[0].charAt(0) == 'S' || parsedInput[0].charAt(0) == 's')&& parsedInput.length >= 2){
            boolean ret = myhash.ScheckF(parsedInput[1], parsedInput[2]);
            if (ret) {
                System.out.println("Yes"); 
            }else{
                System.out.println("No"); 
            }
        }else if((parsedInput[0].charAt(0) == 'L' || parsedInput[0].charAt(0) == 'l')&& parsedInput.length >= 2){
            myhash.List(parsedInput[1]);
            
        }else if((parsedInput[0].charAt(0) == 'D' || parsedInput[0].charAt(0) == 'd')&& parsedInput.length >= 2){
            myhash.Erase(parsedInput[1]);
            System.out.println("Person ["+parsedInput[1]+"] deleted");
        }else if((parsedInput[0].charAt(0) == 'E' || parsedInput[0].charAt(0) == 'e')&& parsedInput.length >= 2){
            
            if(parsedInput.length > 1){
                if(parsedInput.length > 2){
                    if(myhash.ScheckF(parsedInput[1],parsedInput[2])){
                        myhash.DeleteFriendship(parsedInput[1],parsedInput[2]);
                    }else{
                        System.out.println(parsedInput[1]+" has No Friend..!");
                    }
                    //System.out.println("Person ["+parsedInput[1]+"] and ["+parsedInput[2]+"] are friends");//kaldır
                }else{
                    System.out.println("[ERROR] Second person can not be blank..!");
                }
            }else{
                System.out.println("[ERROR] First person can not be blank..!");
            }
            //System.out.println("person deleted");
        }else if((parsedInput[0].charAt(0) == 'O' || parsedInput[0].charAt(0) == 'o')&& parsedInput.length >= 2){
            myhash.Ofriends(parsedInput[1]);
            //System.out.println("Friends Out");
        }else{
            System.out.println("Command Not Found..!");
        }
        return 0;
    }
    
}