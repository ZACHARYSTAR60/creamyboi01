/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd;

import java.util.ArrayList;

/**
 *
 * @author Joseph
 */
public class Character {
    //fields
    private String name;
    private Stats stats;
    private Race race;
    private int weight;
    private double height;
    private char sex;
    private int darkVisionDistance;
    private ArrayList<String> equipment = new ArrayList<>();
    private Role role;
    
    //getters
    public Stats getStats(){
        return stats;}
    public Race getRace(){
        return race;}
    public int getWeight(){
        return weight;}
    public double getHeight(){
        return height;}
    public char getSex(){
        return sex;}
    public int darkVisionDistance(){
        return darkVisionDistance;}
    public ArrayList<String> getEquipment(){
        return equipment;}
    public Role getRole(){
        return role;}
    public String getName(){
        return name;}
    
    //setters
    public void setStats(Stats stats1){
        stats=stats1;}
    public void setRace( Race race1){
        race=race1;}
    public void setWeight(int wght){
        weight=wght;}
    public void setSex(char sexy){
        sex=sexy;}
    public void changeStat(String statType, int changeAmount){
        stats.changeStat(statType.toLowerCase(), changeAmount);}
    public void setEquipment(ArrayList<String> setEQ){
        equipment = setEQ;}
    public void addEquipment(String toAdd){
        equipment.add(toAdd);}
    public void setRole(Role newRole){
        role = newRole;}
    public void setName(String set){
        name = set;}
    
    
    //force override should ususaly be false
    public void setDarkVisionDistance(int newDarkVision, boolean forceOverride){
        if (forceOverride == true)
            darkVisionDistance = newDarkVision;
        else
        {
            if (darkVisionDistance < newDarkVision)
                darkVisionDistance = newDarkVision;
            else
                ;//do nothing
        }
    }
    
    
    //constructors
    
    
    
    /**
     * 
     * @param myStats put predecided stats or use Stats.getRandoStats to generate random stats
     * @param myRace put a race object or use Race.RandomRace
     * @param myWeight
     * @param myHeight
     * @param mySex
     * @param myRole
     * @param myName
     * @param myDarkVision Dark Vision Distance
     */
    public Character(Stats myStats, Race myRace, int myWeight, double myHeight, char mySex, Role myRole, String myName, int myDarkVision){
        stats=myStats;
        race=myRace;
        weight=myWeight;
        height=myHeight;
        sex=mySex;
        role = myRole;
        name = myName;
        darkVisionDistance = myDarkVision;
    }
    public Character(){
        stats= new Stats();
        System.out.println("Old stats before race modifieres:"  + "\n" + " " + stats.toString());
        race = new Race("elf", "high-elf");
        System.out.println(" My race is " + race.toString());
        race.addRaceBonus(this);
        System.out.println("New stats after race modifieres " + "\n" + " " + stats.toString());
        
        System.out.println("OUR recommendation for the class you should play, based on your stats is " +stats.getOptimalClass());
        role = new Role("barbarian");
        weight = this.getRace().determineWeight();  //ALL NEEDS CHANGING
        height = this.getRace().determineHeight();
        sex = 'm';
        System.out.println("Here are some facts about your chacter:  " + weight + "lbs " + height + " " + String.valueOf(sex).toUpperCase());
        Role.addStartingEquipment(this);
        race.addDarkVision(this);       
    }
    
    public Character(String myName, String desiredRace, char mySex, String desiredRole)
    {
        name = myName;
        race = new Race(desiredRace);
        sex = mySex;
        role = new Role(desiredRole);
        stats = new Stats(true);
        weight = race.determineWeight();
        height = race.determineHeight();
        darkVisionDistance = 0;
        race.addDarkVision(this);
    }
    
    
    
    public void printEquipment()
    {
        System.out.println("Your equipment is as follows: ");
        for (int x = 0; x < equipment.size(); x++)
        {
            System.out.println(equipment.get(x));
        }
    }
    
    @Override
    public String toString()
    {
        String ret = "";
        ret += "Name: " + name +"\n";
        ret += race.toString() + " " + role.getClassName() + "\n";
        ret += "Gender: " + sex;
        ret += stats.toString() +"\n";
        ret += "dark vision up to " + darkVisionDistance+ " feet\n";
        ret += "Weight: " +weight + " lbs\n";
        ret += "Hight: " +height + "";
        return ret;
    }
    
    
    
    
    
    
    
    
    
    
    
}
