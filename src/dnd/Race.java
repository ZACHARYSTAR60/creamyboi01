/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joseph
 */
public class Race {
    public static final String[] RACES = {"dragonborn", "dwarf", "elf", "gnome", "half-elf", "half-orc", "halfling", "human", "tiefling"};
    //fields
    private String race;
    
    private String subrace;
    
    //getters
    public String getRace(){
        return race;}
   
    public String getSubrace(){
        return subrace;}
    
    //setters
    public void setRace(String Rce){
        race=Rce;}
    
    public void setSubRace(String subby){
        subrace=subby;}
    
    //constructor
    public Race()
    {
        race = Race.matchTextToRace(randomRace());
        subrace=randomSubRace();
    }
    
    public Race (String desieredRace, String desiredSubRace)
    {
        race = desieredRace.toLowerCase();
        subrace=desiredSubRace.toLowerCase();
        //BUILD MATCHER YOU FUCKING BITCH FUCK YOU AND YOUR FAMILY I FUCKING HATE YOU WHY ARE WE DOING THIS SHIT
    }
    
    public Race(String desieredRace)
    {
        race = matchTextToRace(desieredRace);
        subrace = randomSubRace();
    }
    
  
    
    public static String randomRace(){
        int x= (int)(Math.random()* 100 +1);
        if(x <40)
            return "human";
        if(x>=40 && x<50)
            return "half-elf";
        if(x>=50 && x<55)
            return "halfling";
        if(x>=55 && x<60)
            return "half-orc";
        if(x>=60 && x<70)
            return "dwarf";
        if(x>=70 && x<85)
            return "elf";
        if(x>=85 && x<90)
            return "gnome";
        if(x>=90 && x<91)
            return "dragonborn";
        if(x>=91 && x<100)
            return "tiefling";
      return "PROBLEM";
    }
    public String randomSubRace(){
        int x= (int)(Math.random()*100);
        if(race.equals("elf")){
            if(x<=33)
                subrace="wood-elf";
            else if(x>33 && x<=66)
                subrace="high-elf";
            else
                subrace="dark-elf";
        }
        else if(race.equals("dwarf")){
            if(x>50)
                subrace="mountain-dwarf";
            else
                subrace="hill-dwarf";
        }
        else if(race.equals("gnome")){
            if(x>50)
                subrace="forest-gnome";
            else
                subrace="rock-gnome";
        }
        else
            subrace="none";
        return subrace;
    }
    public void addRaceBonus(Character player){
        int totalbonus=0;
        if(race.equals("half-orc")){
            player.changeStat("strength", 2);
            player.changeStat("constitution", 1);
            
        }
        else if(race.equals("elf")){
            player.changeStat("dexterity", 2);
            if(subrace.equals("wood-elf"))
                player.changeStat("wisdom",1);
            else if(subrace.equals("high-elf"))
                player.changeStat("intelligence",1);
            else
                player.changeStat("charisma",1);
            
        }
        else if (race.equals("human")){
            player.changeStat("strength", 1);
            player.changeStat("dexterity", 1);
            player.changeStat("intelligence", 1);
            player.changeStat("constitution", 1);
            player.changeStat("charisma", 1);
            player.changeStat("wisdom", 1);
            
        }
        else if (race.equals("gnome")){
            player.changeStat("intelligence", 2);
            if(subrace.equals("rock-gnome")){
                player.changeStat("constitution",1);}
            else if(subrace.equals("forest-gnome")){
                player.changeStat("dexterity",1);
            }
            
        }
        else if(race.equals("dwarf")){
            player.changeStat("constitution", 2);
            if(subrace.equals("mountain-dwarf")){
                player.changeStat("strength",2);
            }
            else
                player.changeStat("wisdom",1);
            
        }
        else if(race.equals("halfling")){
            player.changeStat("dexterity", 2);
            
        }
        else if(race.equals("dragonborn")){
            player.changeStat("charisma", 1);
            player.changeStat("strength", 2);
            
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
                String statName = Stats.matchTextToStat(input); //BIG FUCKING ERROR, IF YOU PUT IN A NUMBER IT CRASHED THE ENTIRE PROGRAM
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
        //return totalbonus;
    }
    
    /**
     * takes the input string and matches it to the proper race name
     * @param toMatch
     * @return the proper race string
     */
    public static String matchTextToRace(String toMatch)
    {
        if (toMatch.substring(0, 2).toLowerCase().equals("el"))
            return "elf";
        else if (toMatch.substring(0, 2).toLowerCase().equals("dr"))
            return "dragonborn";
        else if (toMatch.substring(0, 2).toLowerCase().equals("dw"))
            return "dwarf";
        else if (toMatch.substring(0, 2).toLowerCase().equals("gn"))
            return "gnome";
        else if (toMatch.substring(0, 4).toLowerCase().equals("half"))
        {
            if (toMatch.substring(0,6).toLowerCase().equals("half-e"))
                return "half-elf";
            else if (toMatch.substring(0,6).toLowerCase().equals("half-o"))
                return "half-orc";
            else if (toMatch.substring(0, 5).toLowerCase().equals("halfl"))
                return "halfling";
            else
                System.out.println("ERROR IN MATCH TEXT TO RACE METHOD");
        }
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
        else if(race.equals("elf")){
            if(subrace.equals("dark-elf")){
                player.setDarkVisionDistance(120, false);
            }else
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
    
    
    public int determineWeight(){
        int ret = 0;
        if(race.equals("half-orc"))
            ret = 140 +(Dice.roll("2d10")* Dice.roll("2d6"));
        else if(race.equals("half-elf"))
            ret = 110 + (Dice.roll("2d8")* Dice.roll("2d4"));
        else if(race.equals("halfling"))
            ret = 35 + Dice.roll("2d8");
        else if(race.equals("dwarf"))
            ret = 120 +(Dice.roll("2d4")*  Dice.roll("2d6"));
        else if(race.equals("gnome"))
            ret = 35 + Dice.roll("2d4") ;
        else if(race.equals("elf"))
            ret = 90 +(Dice.roll("2d10")*  Dice.roll("1d4"));
        else //human
            ret = 110 +(Dice.roll("2d10")*  Dice.roll("2d4"));
        return ret;
    }
    
    
    public double determineHeight(){
        int inches = 0;
        if(race.equals("half-orc"))
            inches = 58 + Dice.roll("2d10");
        else if(race.equals("half-elf"))
            inches = 57 + Dice.roll("2d8");
        else if(race.equals("halfling"))
            inches = 31 + Dice.roll("2d4");
        else if(race.equals("dwarf"))
            inches = 48 + Dice.roll("2d4");
        else if(race.equals("gnome"))
            inches = 35 + Dice.roll("2d4");
        else if(race.equals("elf"))
            inches = 54 + Dice.roll("2d8");
        else //human
            inches = 56 + Dice.roll("2d10");
        double ret = (inches / 12) + ((inches % 12)/100.0);
        return ret;
        
    }
    
    
    public ArrayList<String> getBonuses()
    {
        ArrayList<String> ret = new ArrayList<>();
        if (race.equals("dwarf")){
            ret.add("Advantage on saving throws against poison");
            ret.add("Advantage against poison damage");
            ret.add("Proficiency with battleaxe, handaxe, light hammer, and warhammer");
            ret.add("check tool proficiency");
            ret.add("Gain double proficiency on all history checks made related to stonework");
            ret.add("Speek/Read/Write: common and dwarvish");
            if(subrace.equals("hill-dwarf")){
                ret.add("your hit point max increases by one every level");
            }
            else if(subrace.equals("mountain-dwarf")){
                ret.add("you have proficiency with light and medium armor");
            }
            else
                System.out.println("ERROR IN GET BONUSES METHOD UNDER THE RACE CLASS");
            
        }
        else if(race.equals("elf")){
            ret.add("You have profiency in perception");
            ret.add("you have advantage on saving throws against being charmed");
            ret.add("magic cant put you to sleep");
            ret.add("you can long rest for only 4 hours if you trance");
            ret.add("Speek/Read/Write: Common and Elvish");
            if(subrace.equals("high-elf")){
                ret.add("you have proficiency with longsword, shortsword, shortbow, and longbow");
            }
            else if(subrace.equals("wood-elf")){
                ret.add("you have proficiency with longsword, shortsword, shortbow, and longbow");
                ret.add("you can attempt to hide uner natural phenomena that it would make senes to be able to hide by");
            }
            else if(subrace.equals("dark-elf")){
                ret.add("you have disadvantage on attack rolls and perception checks that rely on sight while any party involved is in direct sunlight");
                ret.add("you know the danceing lights cantrip, faerie fire spell, and darkness spell");
                ret.add("you have proficiency with rapiers, shortswords, and hand crossbows");
            }
        }
        else if (race.equals("halfling")){
            ret.add("if you roll a 1 on a d20, you may reroll the die once");
            ret.add("you have advantage on saving throws against being frightened");
            ret.add("you can move through the space of any creature one size larger than you");
            ret.add("Speak/Read/Write: Common and halfling");
            ret.add("aditional benifits from the different types of halflings");
            
        }
        else if(race.equals("human")){
            ret.add("Speak/Read/Wright: Common and one other language");
        }
        else if(race.equals("dragonborn")){
            ret.add("you can spit damage of a spesific type, refer to page 34");
            ret.add("you have resistence to the type of damage you spit");
            ret.add("Speak/Read/Write: Common and Dragonic (a very old language)");
        }
        else if(race.equals("gnome")){
            ret.add("you have advantage on intelegence, wisdom, and charisma saving throws against magic");
            if(subrace.equals("forest-gnome")){
                ret.add("you know the minor illusion cantrip");
                ret.add("you can communicate with small or smaller beasts");
            }
            else if (subrace.equals("rock-gnome")){
                ret.add("whenever you make any history checks related to magic, alchemy, or technology, add twice your proficiency bonus");
                ret.add("you can build some cool trinkits (see page 37)");
            }
        }
        else if(race.equals("half-elf")){
            ret.add("you cant be put to sleep by magic");
            ret.add("you have advantage against saving throws to be charmed");
            ret.add("gain proficiency on 2 skills of your choice");
            ret.add("Speak/Read/Wright: Common, Elvish, and one language of your choice");
        }
        else if(race.equals("half-orc")){
            ret.add("you gain proficiency in intimidation");
            ret.add("if your droped to 0hp, you can go back up to 1, you must long rest before reuse");
            ret.add("if you crit hit, you may add one more of the weapons damage dice");
            ret.add("Speak/Read/Wright: Common and Orc");
        }
        else if(race.equals("tiefling")){
            ret.add("you have resistence to fire damage");
            ret.add("you know the thaumaturgy cantrip, the hellish spell, and the darkness spell");
            ret.add("Speak/Read/Wright: Common and Infernal");
        }
        return ret;
        
    }
    
    public static String randomNameGenerator(Character player){
        String name="";
        int x=(int)(Math.random()*17+1);
        if(player.getRace().equals("dwarf"))
            if(player.getSex()=='m' && x==1)
                name="Adrik";
            else if(player.getSex()=='m' && x==2)
                name="Albrick";
            else if(player.getSex()=='m' && x==3)
                name="Baren";
            else if(player.getSex()=='m' && x==4)
                name="Barendd";
            else if(player.getSex()=='m' && x==5)
                name="Brottor";
            else if(player.getSex()=='m' && x==6)
                name="Bruenor";
            else if(player.getSex()=='m' && x==7)
                name="Dane";
            else if(player.getSex()=='m' && x==8)
                name="Derrak";
            else if(player.getSex()=='m' && x==9)
                name="Delg";
            else if(player.getSex()=='m' && x==10)
                name="Eberk";
            else if(player.getSex()=='m' && x==11)
                name="Eiknel";
            else if(player.getSex()=='m' && x==12)
                name="Fargrim";
            else if(player.getSex()=='m' && x==13)
                name="Flint";
            else if(player.getSex()=='m' && x==14)
                name="Guardian";
            else if(player.getSex()=='m' && x==15)
                name="Harbek";
            else if(player.getSex()=='m' && x==16)
                name="Killdrak";
            else if(player.getSex()=='m' && x==17)
                name="Morgran";
            else if(player.getSex()=='m' && x==18)
                name="Orisky";
        
        return name;
                        
                        
                
                
                    
                
            
            
        
    }
    
    
    @Override
    public String toString()
    {
        String ret= race;
        if(subrace.equals("none"))
            return ret;
        else
            ret+=" my subrace is " + subrace;
        return ret;
    }
}
