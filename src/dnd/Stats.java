
package dnd;


public class Stats  {
    private int strength;
    private int inteligence;
    private int dexterity;
    private int wisdom;
    private int constitution;
    private int charisma;
    
    public int getStr(){
        return strength;}
    public int getInt(){
        return inteligence;}
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
        inteligence=Int;}
    public void setDex(int Dex){
        dexterity=Dex;}
    public void setWis(int Wis){
        wisdom=Wis;}
    public void setCons(int Cons){
        constitution=Cons;}
    public void setChar(int Char){
        charisma=Char;}
  
    
    
    //Constructors
    public Stats (int myStr, int myInt, int myDex, int myWis, int myCons, int myChar){
        strength=myStr;
        inteligence=myInt;
        dexterity=myDex;
        wisdom=myWis;
        constitution=myCons;
        charisma=myChar;
        }
    public Stats(){
        strength=getRandoStats();
        inteligence=getRandoStats();
        dexterity=getRandoStats();
        wisdom=getRandoStats();
        constitution=getRandoStats();
        charisma=getRandoStats();
        
    }
    
    //4d6 drop the lowest roll 
    public int getRandoStats(){ 
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
    
    public String getOptimalType(){
        if (strength > inteligence && wisdom >=10)
            return "Fighter";
        else if( strength > inteligence && inteligence < 10)
            return "Barbarian";
        else if (inteligence > strength && wisdom > 10)
            return "Wizard";
        else
            return "Daddy";
    }
   
   
   //OOPS SORRY BUT LETS TRY THIS SHIT OUT 7/9/2018 ZACH WONG
    
    public String toString(){
       String ret= "My Strength is " + strength +" My inteligence is " + inteligence + " My dexterity is " + dexterity + " My wisdom is " + wisdom + " My constittution is " + constitution + " My charisma is " + charisma;
       //String acc= ", My race is " + determineRace(race) + ", My total Stat bonus is " + addRaceBonus(totalbonus);
       return ret;
   }
       
      
   
}
