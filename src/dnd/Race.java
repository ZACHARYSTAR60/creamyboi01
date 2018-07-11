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
    private String subrace;
    
    //getters
    public String getRace(){
        return race;}
    public int getBonus(){
        return totalbonus;}
    public String getSubrace(){
        return subrace;}
    
    //setters
    public void setRace(String Rce){
        race=Rce;}
    public void setBonus(int Bonus){
        totalbonus=Bonus;}
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
            return "elvish";
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
        if(race.equals("elvish")){
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
                subrace="deep-gnome";
            else
                subrace="rock-gnome";
        }
        else
            subrace="none";
        return subrace;
    }
    public int addRaceBonus(Character player){
        int totalbonus=0;
        if(race.equals("half-orc")){
            player.changeStat("strength", 2);
            player.changeStat("constitution", 1);
            
        }
        else if(race.equals("elvish")){
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
            else if(subrace.equals("deep-gnome")){
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
        return totalbonus;
    }
    
    /**
     * takes the input string and matches it to the proper race name
     * @param toMatch
     * @return the proper race string
     */
    public static String matchTextToRace(String toMatch)
    {
        if (toMatch.substring(0, 2).toLowerCase().equals("el"))
            return "elvish";
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
        else if(race.equals("elvish")){
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
        int x=(int)(Math.random()*250);
        if(race.equals("half-orc"))
            x+=100;
        else if(race.equals("half-elf"))
            x-=50;
        else if(race.equals("halfling"))
            x-=100;
        else if(race.equals("dwarf"))
            x+=50;
        else if(race.equals("gnome"))
            x-=100;
        else if(race.equals("elf"))
            x-=25;
        else
            x+=0;
        return x;
    }
    public double determineHeight(){
        double x= (double)(Math.random()*5.00);
        if(race.equals("half-orc"))
            x+=2.00;
        else if(race.equals("half-elf"))
            x-=.50;
        else if(race.equals("halfling"))
            x-=2.10;
        else if(race.equals("dwarf"))
            x-=2.00;
        else if(race.equals("gnome"))
            x-=1.00;
        else if(race.equals("elf"))
            x+=2.5;
        else
            x+=0;
        return x;
        
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
