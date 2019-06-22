
package dnd;

import java.util.Scanner;


public class Main {

  
    public static void main(String[] args) {
      //name
       Scanner input=new Scanner(System.in);
       System.out.println("Please enter your character's name");
       String name=input.nextLine();
       
       //race
        System.out.println("Please enter your character's race");
       String race=input.nextLine();
       
        
        //Gender *Something funky
         System.out.println("Please enter your character's Gender");
       char gender=input.nextLine().charAt(0);
       
       //role
        System.out.println("Please enter your character's class");
       String role=input.nextLine();
       
       //level
        System.out.println("Please enter your character's level");
       int lvl=Integer.valueOf(input.nextLine());
       
        Character choice= new Character(name,race,gender,role,lvl);
      System.out.println("\n");
      System.out.println(choice);
      
      
      
      
      
    }
}
