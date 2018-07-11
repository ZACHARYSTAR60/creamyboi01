/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd;

/**
 *
 * @author Joseph
 */
public class Character {
    //fields
    private Stats stats;
    private Race race;
    private int weight;
    private double height;
    private char sex;
    private int darkVisionDistance;
    
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
     */
    public Character(Stats myStats, Race myRace, int myWeight, double myHeight, char mySex){
        stats=myStats;
        race=myRace;
        weight=myWeight;
        height=myHeight;
        sex=mySex;
    }
    public Character(){
        stats= new Stats();
        System.out.println("old stats before race modifieres " + stats.toString());
        race = new Race();
        System.out.println("My race is " + race.toString());
        race.addRaceBonus(this);
        System.out.println("new stats after race modifieres " + stats.toString());
        weight = 150;  //ALL NEEDS CHANGING
        height = 5.10;
        sex = 'm';
                
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
