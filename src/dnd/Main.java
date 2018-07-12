
package dnd;


public class Main {

  
    public static void main(String[] args) {
      Character zach = new Character("Elres", "elf", 'f',"ranger", 1);
      System.out.println(zach);
      for (int x= 0; x < zach.getRace().getBonuses().size(); x++){
          System.out.println(zach.getRace().getBonuses().get(x));
      }
      
      
      
      
      
    }
}
