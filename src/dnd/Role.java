
package dnd;

import java.util.Scanner;

/**
 *
 * @author WongZ 
 */
public class Role {
    public static final String[] CLASSES = {"barbarian", "bard", "cleric","druid","fighter","monk","paladin","ranger","rogue","sorcerer","warlock","wizard"};
    public static final int[] HITDIE = {12,8,8,8,10,8,10,8,8,6,8,6};
    //fields
    private String className;
    private int healthDie;
    
    //getters
    public String getClassName(){
        return className;}
    public int getHealthDie(){
        for (int x = 0; x < CLASSES.length;x++){
            if(CLASSES[x].equals(className))
                return HITDIE[x];
        }
            
        System.out.println("ERROR IN GET HEALTH DIE METHOD UNDER ROLE CLASS");
        return 8;   
    }

    
    //setters
    public void setClassName(String newName){
        className = newName;}
    public void setHealthDie(int newHealthDie){
        healthDie = newHealthDie;}
    
    //constructors
    public Role(String desieredRole)
    {
        className = matchTextToClass(desieredRole);
        healthDie = HITDIE[findClassPosition(matchTextToClass(className))];
    }
    
    public Role(Character player)
    {
        className = player.getStats().getOptimalClass();
        healthDie = HITDIE[findClassPosition(matchTextToClass(className))];
    }
    
    public Role()
    {
        className = CLASSES[(int)(Math.random()*12+1)];
    }
    
    
    public int findClassPosition(String classType)
    {
        for(int x = 0; x < CLASSES.length;x++)
        {
            if(CLASSES[x].equals(classType))
                return x;
        }
        System.out.println("ERROR IN FIND CLASS POSITON METHOD UNDER ROLE");
        return 0;
    }
    
    public static void addStartingEquipment(Character player)  //man not finish
    {
        if (player.getRole().getClassName().equals("barbarian")) //barbarian starting equipment
        {
            String[] barbStartingEQ = {"Greataxe", "any martial melee weapon"};
            for (boolean done = true; done;)
            {
                System.out.println("1)" + barbStartingEQ[0] + " or 2)" + barbStartingEQ[1]);
                Scanner scanInput = new Scanner(System.in);
                String input = scanInput.nextLine();
                
                if(input.equals("1") == false && input.equals("2") == false)
                    System.out.println("Invalid input");
                else
                {
                    done = false;
                    if (Integer.valueOf(input) == 1)
                        player.addEquipment(barbStartingEQ[0]);
                    else
                        player.addEquipment(barbStartingEQ[1]+ " ACTUALLY PUT SOMETHIN HERE");
                }
                    
            }
            for (boolean done = true; done;)
            {
                System.out.println("1)Two handaxes or 2)any simple weapon");
                Scanner scanInput = new Scanner(System.in);
                String input = "";
                input = scanInput.nextLine();
                
                if(input.equals("1") == false && input.equals("2") == false)
                    System.out.println("Invalid input");
                else
                {
                    done = false;
                    if (Integer.valueOf(input) == 1)
                        player.addEquipment("2 Handaxes");
                    else
                        player.addEquipment("any simple weapon ACTUALLY PUT SOMETHIN HERE");
                }
                    
            }
            System.out.println("You also get an edxplorer's pack and four javelins");
            player.addEquipment("Explorer's pack");
            player.addEquipment("4 javelins");
        }
        
    }
    
    public String matchTextToClass(String original)
    {
        String toMatch = original.toLowerCase();
        if (toMatch.substring(0,4).equals("barb"))
            return "barbarian";
        else if(toMatch.substring(0,4).equals("bard"))
            return "bard";
        else if(toMatch.substring(0,1).equals("c"))
            return "cleric";
        else if(toMatch.substring(0,1).equals("d"))
            return "druid";
        else if(toMatch.substring(0,1).equals("f"))
            return "fighter";
        else if(toMatch.substring(0,1).equals("m"))
            return "monk";
        else if(toMatch.substring(0,1).equals("p"))
            return "paladin";
        else if(toMatch.substring(0,2).equals("ra"))
            return "ranger";
        else if(toMatch.substring(0,2).equals("ro"))
            return "rogue";
        else if(toMatch.substring(0,1).equals("s"))
            return "sorcerer";
        else if(toMatch.substring(0,2).equals("wa"))
            return "warlock";
        else if(toMatch.substring(0,2).equals("wi"))
            return "wizard";
        else
            System.out.println("ERROR IN MATCH TEXT TO CLASS METHOD");
            return "fighter";
        
    }
}
