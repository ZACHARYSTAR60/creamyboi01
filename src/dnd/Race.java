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
public class Race {
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
        race = desieredRace;
    }
    
  
    
    public String randomRace(){
        int x= (int)(Math.random()* 100 +1);
        if(x <20)
            race="human";
        if(x>=20 && x<30)
            race="half-elf";
        if(x>=30 && x<40)
            race="halfling";
        if(x>=40 && x<50)
            race="Half-orc";
        if(x>=50 && x<60)
            race="Dwarvish";
        if(x>=60 && x<70)
            race="Elvish";
        if(x>=70 && x<80)
            race="gnomish";
        if(x>=80 && x<90)
            race="dragonborn";
        if(x>=90 && x<100)
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
        if(race.equals("Elvish")){
            player.changeStat("dexterity", 2);
            totalbonus=2;
        }
        if (race.equals("human")){
            player.changeStat("strength", 1);
            player.changeStat("dexterity", 1);
            player.changeStat("inteligence", 1);
            player.changeStat("constitution", 1);
            player.changeStat("charisma", 1);
            player.changeStat("wisdom", 1);
            totalbonus=6;
        }
        if (race.equals("gnomish")){
            player.changeStat("inteligence", 2);
            totalbonus=2;
        }
        if(race.equals("Dwarvish")){
            player.changeStat("constitution", 2);
            totalbonus=2;
        }
        if(race.equals("halfling")){
            player.changeStat("dexterity", 2);
            totalbonus=2;
        }
        if(race.equals("dragonborn")){
            player.changeStat("charisma", 1);
            player.changeStat("strength", 2);
            totalbonus=3;
        }
        
        
        
        return totalbonus;
        
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