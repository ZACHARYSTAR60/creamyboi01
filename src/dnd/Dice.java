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
    public static final String BASE_NUMBERS = "0123456789";
    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    
    
    
    public static int roll(String diceRoll)     
    {
        int numRolls = 0;
        int typeRoll = 0;
        int posOfLetter = 0;
        for(int x = 0; x < diceRoll.length();x++)
        {
            if (BASE_NUMBERS.indexOf(diceRoll.charAt(x)) < 0)
            {
                posOfLetter = x;
                if (x == 0)
                    return 1000;
                else
                    numRolls = Integer.valueOf(diceRoll.substring(0,x));
                break;
            }    
        }
        for(int x = posOfLetter+1; x < diceRoll.length();x++)
        {
            if (BASE_NUMBERS.indexOf(diceRoll.charAt(x)) < 0)
            {
                if (x == 0 || x == posOfLetter+1)
                    return 1000;
                else
                    typeRoll = Integer.valueOf(diceRoll.substring(posOfLetter+1,x));
                break;
            }
            
        }
        if (typeRoll == 0)
            typeRoll = Integer.valueOf(diceRoll.substring(posOfLetter+1,diceRoll.length()));
        
        
        int total = 0;
        while(numRolls > 0)
        {
            total += (int)(Math.random()*typeRoll + 1);
            numRolls--;
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
