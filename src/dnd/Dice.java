/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd;

import java.util.Arrays;

/**
 *
 * @author Joseph
 */
public class Dice {
    public static final char[] BASE_NUMBERS = {'0','1','2','3','4','5','6','7','8','9'};
    public static final char[] LETTERS = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    
    
    
    public static int roll(String diceRoll)     
    {
        int total = 0;
        if((Arrays.binarySearch(BASE_NUMBERS, diceRoll.charAt(0)) < 0) && 
           (Arrays.binarySearch(LETTERS, diceRoll.charAt(1))< 0 ) && 
           (Arrays.binarySearch(BASE_NUMBERS, diceRoll.charAt(2))) < 0) //can be broken if letter is entered after dice i.e. 2d10b will break this
        {
            System.out.println("Invalid dice roll");
            return 1000;
        }
        else
        {
            int numRolls = Integer.valueOf(diceRoll.substring(0,1));
            int typeRoll = Integer.valueOf(diceRoll.substring(2,diceRoll.length()));
            while(numRolls > 0)
            {
                total += (int)(Math.random()*typeRoll + 1);
                numRolls--;
            }
        }
        return total;
           
    }
    
    
    public static int d20Advantage()
    {
        int roll1 = (int)(Math.random()*20 + 1);
        int roll2 = (int)(Math.random()*20 + 1);
        return Integer.max(roll1, roll2);
    }
    
    
    public static int d20()
    {
        return (int)(Math.random()*20 + 1);
    }
    
    public static int d20Disadvantage()
    {
        int roll1 = (int)(Math.random()*20 + 1);
        int roll2 = (int)(Math.random()*20 + 1);
        return Integer.min(roll1, roll2);
    }
}
