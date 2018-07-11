
package dnd;

/**
 *
 * @author WongZ 
 */
public class Role {
    public static final String[] CLASSES = {"barbarian", "bard", "cleric","druid","fighter","monk","paladin","ranger","rogue","sorcerer","warlock","wizerd"};
    //public static final int[] HITDIE = {12,8,
    //fields
    private String className;
    private int healthDie;
    private String equipment;
    
    //getters
    public String getClassName(){
        return className;}
    public int getHealthDie(){
        return healthDie;}
    public String getEquipment(){
        return equipment;}
    
    //setters
    public void setClassName(String newName){
        className = newName;}
    public void setHealthDie(int newHealthDie){
        healthDie = newHealthDie;}
    public void setEquipment(String newEquipment){
        equipment = newEquipment;}
    
    //constructors
    public Role(Character player)
    {
        className = player.getStats().getOptimalClass();
        
    }
}
