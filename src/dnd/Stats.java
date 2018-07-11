
package dnd;

import static dnd.Dice.BASE_NUMBERS;
import static dnd.Dice.LETTERS;
import java.util.ArrayList;
import java.util.Scanner;


public class Stats  {
    private int strength;
    private int intelligence;
    private int dexterity;
    private int wisdom;
    private int constitution;
    private int charisma;
    
    public int getStr(){
        return strength;}
    public int getInt(){
        return intelligence;}
    public int getDex(){
        return dexterity;}
    public int getWis(){
        return wisdom;}
    public int getCons(){
        return constitution;}
    public int getChar(){
        return charisma;}
    
    public void setStr(int Str){
        strength=Str;}
    public void setInt(int Int){
        intelligence=Int;}
    public void setDex(int Dex){
        dexterity=Dex;}
    public void setWis(int Wis){
        wisdom=Wis;}
    public void setCons(int Cons){
        constitution=Cons;}
    public void setChar(int Char){
        charisma=Char;}
    
    
    
  public void changeStat(String statType, int changeAmount){
      String statTypeMatched = Stats.matchTextToStat(statType);
      
        if ("strength".equals(statTypeMatched))
            strength += changeAmount;
        else if ("intelligence".equals(statTypeMatched))
            intelligence += changeAmount;
        else if ("dexterity".equals(statTypeMatched))
            dexterity += changeAmount;
        else if ("wisdom".equals(statTypeMatched))
            wisdom += changeAmount;
        else if ("constitution".equals(statTypeMatched))
            constitution += changeAmount;
        else if ("charisma".equals(statTypeMatched))
            charisma += changeAmount;
        
    }
    
    
    //Constructors
    public Stats (int myStr, int myInt, int myDex, int myWis, int myCons, int myChar){
        strength=myStr;
        intelligence=myInt;
        dexterity=myDex;
        wisdom=myWis;
        constitution=myCons;
        charisma=myChar;
        }
    
    public Stats(){
        strength=getRandoStats();
        intelligence=getRandoStats();
        dexterity=getRandoStats();
        wisdom=getRandoStats();
        constitution=getRandoStats();
        charisma=getRandoStats();
    }
    
    /**
     * 
     * @param letAssign Will let assign regardless of param value
     */
    public Stats(boolean letAssign){
        ArrayList<Integer> availiableStats = new ArrayList<>();
        for(int x = 0; x < 6 ;x++)
        {
            availiableStats.add(getRandoStats());
        }
        
        String[] statNames = {"strength", "intelligence", "dexterity", "wisdom", "constitution","charisma"};
        for(int z = 0; z < 6; z++)
        {
            System.out.println("Enter the stat for " + statNames[z]);
            System.out.println("Availiable Stats left: " + availiableStats.toString());
            for(boolean notDone = true; notDone;) //assigns one stat and checks to make sure the input is value
            {
                Scanner scanInput = new Scanner(System.in);
                String input = scanInput.nextLine();
                boolean isValid = true;
                for (int x = 0; x < input.length(); x++)
                {
                    if (BASE_NUMBERS.indexOf(input.charAt(x)) < 0){
                        System.out.println("Invalid Input");
                        isValid = false;
                        break;
                    }
                }
                int selectedStat = 0;
                if (isValid == true){
                    selectedStat = Integer.valueOf(input);
                    if(availiableStats.indexOf(selectedStat) >= 0){
                       notDone = false;
                       changeStat(statNames[z],availiableStats.get(availiableStats.indexOf(selectedStat)));
                       System.out.println("you entered " + availiableStats.remove(availiableStats.indexOf(selectedStat))+ " for " + statNames[z]);
                    } else{
                        System.out.println("Stat no longer Availiable");
                    }

                }
                else{
                    System.out.println("please try again");
                }


            }
        }
    }
            
            
    
            
            
            
    //4d6 drop the lowest roll 
    public static int getRandoStats(){ 
        int[] rand={(int)(Math.random()*6+1),(int)(Math.random()*6+1),(int)(Math.random()*6+1),(int)(Math.random()*6+1)};
        int min = 20;
        int pos = 0;
        for(int x =0; x < rand.length; x++)
        {
            if (rand[x] < min)
            {
                min = rand[x];
                pos = x;
            }
        }
        rand[pos] = 0;
        int sum = 0;
        for (int x = 0; x < rand.length; x++)
        {
            sum += rand[x];
        }
        return sum;
    }
    
    public String getOptimalClass(){
        if (strength > intelligence && constitution >=12)
            return "Fighter";
        else if( strength > intelligence && intelligence < 10)
            return "Barbarian";
        else if (intelligence > strength && wisdom > 10)
            return "Wizard";
        else if( dexterity>strength && intelligence>wisdom)
            return "Rouge";
        else if( wisdom>strength && constitution>dexterity)
            return "Cleric";
        else if( charisma> strength && dexterity > constitution)
            return "Bard";
        else if( dexterity>strength && wisdom>charisma)
            return "Ranger";
        else if( charisma>wisdom && intelligence> dexterity)
            return "Warlock";
        else if( dexterity>strength && wisdom>intelligence)
            return "Monk";
        else if( intelligence>strength && charisma>wisdom)
            return "Sorcerer";
        else if(strength>wisdom && strength >intelligence && strength> dexterity)
            return "Fighter";
                   
        else
            return "Daddy";
    }
    
    /**
     * Takes the input and matches it to the proper stat name
     * @param toMatch
     * @return The full string of the stat
     */
    public static String matchTextToStat(String toMatch)
    {
        if (toMatch.substring(0, 1).toLowerCase().equals("s"))
            return "strength";
        else if (toMatch.substring(0, 1).toLowerCase().equals("d"))
            return "dexterity";
        else if (toMatch.substring(0, 2).toLowerCase().equals("co"))
            return "constitution";
        else if (toMatch.substring(0, 1).toLowerCase().equals("i"))
            return "intelligence";
        else if (toMatch.substring(0, 1).toLowerCase().equals("w"))
            return "wisdom";
        else if (toMatch.substring(0, 2).toLowerCase().equals("ch"))
            return "charisma";
        System.out.println("ERROR IN MATCH TEXT TO STAT");
        return "DID NOT MATCH";
    }
   
   
   //OOPS SORRY BUT LETS TRY THIS SHIT OUT 7/9/2018 ZACH WONG
    
    @Override
    public String toString(){
       String ret= "My Strength is " + strength + "\n" + " My intelligence is " + intelligence + "\n" + " My dexterity is " + dexterity + "\n" + " My wisdom is " + wisdom + "\n" + " My constittution is " + constitution + "\n" + " My charisma is " + charisma;
       return ret;
   }
       
      
   
}
