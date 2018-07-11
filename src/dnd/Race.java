/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd;

import java.util.Scanner;

/**
 *
 * @author Joseph
 */
public class Race {
    public static final String[] RACES = {"dragonborn", "dwarf", "elvish", "gnome", "half-elf", "half-orc", "halfling", "human", "tiefling"};
    //fields
    private String race;
    private int totalbonus;
    
    //getters
    public String getRace(){
        return race;}
    public int getBonus(){
        return totalbonus;}
    
    //setters
    public void setRace(String Rce){
        race=Rce;}
    public void setBonus(int Bonus){
        totalbonus=Bonus;}
    
    //constructor
    public Race()
    {
        race = randomRace();
    }
    
    public Race (String desieredRace)
    {
        race = desieredRace.toLowerCase();
    }
    
  
    
    public String randomRace(){
        int x= (int)(Math.random()* 100 +1);
        if(x <40)
            race="human";
        if(x>=40 && x<50)
            race="half-elf";
        if(x>=50 && x<55)
            race="halfling";
        if(x>=55 && x<60)
            race="half-orc";
        if(x>=60 && x<70)
            race="dwarvish";
        if(x>=70 && x<85)
            race="elvish";
        if(x>=85 && x<90)
            race="gnomish";
        if(x>=90 && x<91)
            race="dragonborn";
        if(x>=91 && x<100)
            race="tiefling";
      return race;
    }
    
    public int addRaceBonus(Character player){
        int totalbonus=0;
        if(race.equals("Half-orc")){
            player.changeStat("strength", 2);
            player.changeStat("constitution", 1);
            totalbonus=3;
        }
        else if(race.equals("Elvish")){
            player.changeStat("dexterity", 2);
            totalbonus=2;
        }
        else if (race.equals("human")){
            player.changeStat("strength", 1);
            player.changeStat("dexterity", 1);
            player.changeStat("inteligence", 1);
            player.changeStat("constitution", 1);
            player.changeStat("charisma", 1);
            player.changeStat("wisdom", 1);
            totalbonus=6;
        }
        else if (race.equals("gnomish")){
            player.changeStat("inteligence", 2);
            totalbonus=2;
        }
        else if(race.equals("Dwarvish")){
            player.changeStat("constitution", 2);
            totalbonus=2;
        }
        else if(race.equals("halfling")){
            player.changeStat("dexterity", 2);
            totalbonus=2;
        }
        else if(race.equals("dragonborn")){
            player.changeStat("charisma", 1);
            player.changeStat("strength", 2);
            totalbonus=3;
        }
        else if(race.equals("tiefling")){
            player.changeStat("intelegence", 1);
            player.changeStat("charisma", 2);
        }
        else if(race.equals("half-elf")){
            player.changeStat("charisma", 1);
            for (int additionsLeft = 2; additionsLeft >0;){
                System.out.println("You can pick one or more stats to add " + additionsLeft + " to whichever stats you want, type the name of the stat");
                Scanner scanInput = new Scanner(System.in);
                String input = scanInput.nextLine();
                String statName = Stats.matchTxtToStat(input);
                if (statName.equals("DID NOT MATCH"))
                    System.out.println("Your input did not match, try again");
                else
                {
                    System.out.println("Now input the number you want to add to your stat");
                    Scanner scanInputForValue = new Scanner(System.in);
                    int changeValue = scanInputForValue.nextInt();
                    if (changeValue <= additionsLeft && changeValue >= 0){
                        player.changeStat(statName, changeValue);
                        additionsLeft -= changeValue;
                    }
                    else
                        System.out.println("Your input was invalid, please try again");
                }
            }
        }
        return totalbonus;
    }
    
    /**
     * takes the input string and matches it to the proper race name
     * @param toMatch
     * @return the proper race string
     */
    public static String matchTxtToRace(String toMatch)
    {
        if (toMatch.substring(0, 2).toLowerCase().equals("el"))
            return "elvish";
        else if (toMatch.substring(0, 2).toLowerCase().equals("dr"))
            return "dragonborn";
        else if (toMatch.substring(0, 2).toLowerCase().equals("dw"))
            return "dwarf";
        else if (toMatch.substring(0, 2).toLowerCase().equals("gn"))
            return "gnome";
        else if (toMatch.substring(0, 6).toLowerCase().equals("half-e"))
            return "half-elf";
        else if (toMatch.substring(0, 6).toLowerCase().equals("half-o"))
            return "half-orc";
        else if (toMatch.substring(0, 2).toLowerCase().equals("ha"))
            return "halfling";
        else if (toMatch.substring(0, 2).toLowerCase().equals("ti"))
            return "tiefling";
        else if (toMatch.substring(0, 2).toLowerCase().equals("hu"))
            return "human";
        return "DID NOT MATCH";
    }
    
    
    
    
    public void addDarkVision(Character player){
        if(race.equals("Half-orc")){
            player.setDarkVisionDistance(60, false);
        }
        else if(race.equals("Elvish")){
            player.setDarkVisionDistance(60, false);
        }
        else if (race.equals("human")){
            player.setDarkVisionDistance(0, false);
        }
        else if (race.equals("gnomish")){
            player.setDarkVisionDistance(90, false);
        }
        else if(race.equals("Dwarvish")){
            player.setDarkVisionDistance(60, false);
        }
        else if(race.equals("halfling")){
            player.setDarkVisionDistance(0, false);
        }
        else if(race.equals("dragonborn")){
            player.setDarkVisionDistance(60, false);
        }
        else if(race.equals("tiefling")){
            player.setDarkVisionDistance(60, false);
        }
    }
    
    
    public String toString()
    {
        return race;
    }
}
//public int RandomRace(){
//         int Me= (int)(Math.random()* 100 +1);
//        return Me;}
//    public String determineRace(String race1){
//        int x= (int)(Math.random()* 100 +1);
//        if(x <20)
//            race="human";
//        if(x>=20 && x<30)
//            race="half-elf";
//        if(x>=30 && x<40)
//            race="halfling";
//        if(x>=40 && x<50)
//            race="Half-orc";
//        if(x>=50 && x<60)
//            race="Dwarvish";
//        if(x>=60 && x<70)
//            race="Elvish";
//        if(x>=70 && x<80)
//            race="gnomish";
//        if(x>=80 && x<90)
//            race="dragonborn";
//        if(x>=90 && x<100)
//            race="tiefling";
//      return race;
//    }
//    
//    public int addRaceBonus(int bonus1){
//        int totalbonus=0;
//        if(race.equals("Half-orc")){
//            strength+=2;
//            constitution+=1;
//            totalbonus=3;
//        }
//        if(race.equals("Elvish")){
//            dexterity+=2;
//            totalbonus=2;
//        }
//        if (race.equals("human")){
//            strength+=1;
//            dexterity+=1;
//            inteligence+=1;
//            constitution+=1;
//            charisma+=1;
//            wisdom+=1;
//            totalbonus=6;
//        }
//        if (race.equals("gnomish")){
//            inteligence+=2;
//            totalbonus=2;
//        }
//        if(race.equals("Dwarvish")){
//            constitution+=2;
//            totalbonus=2;
//        }
//        if(race.equals("halfling")){
//            dexterity+=2;
//            totalbonus=2;
//        }
//        if(race.equals("dragonborn")){
//            charisma+=1;
//            strength+=2;
//            totalbonus=3;
//        }
//        
//        
//        
//        return totalbonus;
//        
//    }