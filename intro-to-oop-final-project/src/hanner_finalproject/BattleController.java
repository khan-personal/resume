/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL PROJECT
 */
package hanner_finalproject;

import java.util.Random;

public class BattleController 
{
    double guards = 2;
    double guardAttackMod = 1.0;
    double userAttackMod = 1.0;
    double guardAttack;
    double userAttack;
    double guardLife;
    double life;
    double meditateAmount;
    boolean full = false;
    boolean win = false;
    boolean dead = false;
    
    GameView input = new GameView();
    Admin admin = new Admin();
    Random random = new Random();


    public void initialize()
    {
        System.out.println(guards);
        guardLife = guards * 2;
        
        while (!win && !dead)
        {
            admin.battleIntro();
            
            if (guards == 0)//if no guards exit battle!
            {
                input.noGuards();
                win = true;
            }
            else if (guards > 0)
            {            
                fight();
            }
        }
    }
    
    public void fight()
    {        
        if (!dead && !win && full && guards > 0)
        {
            input.startFullBattle();
            while (!dead && !win && full && life > 0 && guards > 0)//if user ate too much 
            {   //guard turn
                battleDisplay();
                input.guardAttack();
                System.out.println("\n\t" + guards + " guard/s attack!");
                guardAttack();
                System.out.println("\n\tGuards do " + guardAttack + " damage to Yousir!");
                checkDeath();
                if (dead)
                {
                    break;
                }
                winCheck();//see if user wins
                if (win)
                {
                    break;
                }
                //user turn
                battleDisplay();
                fightChoice();
                if (input.battleChoice == 'A')
                {
                    System.out.println("\n\tYousir does " + userAttack + " damage!");
                }
                else if (input.battleChoice == 'B')
                {
                    System.out.println("\n\tYousir recovers " + meditateAmount + " life!");
                }
                System.out.println("\n\tYousir does " + userAttack + " damage!");
                checkDeath();
                if (dead)
                {
                    break;
                }
                winCheck();//see if user wins
                if (win)
                {
                    break;
                }
            }           
        }
        
        if (!dead && !win && !full && guards > 0)
        {
            input.startBattle();
            
            while (!dead && !win && !full && life > 0 && guards > 0)//if user didn't eat too much
            {   //user turn
                battleDisplay();
                fightChoice();
                if (input.battleChoice == 'A')
                {
                    System.out.println("\n\tYousir does " + userAttack + " damage!");
                }
                else if (input.battleChoice == 'B')
                {
                    System.out.println("\n\tYousir recovers " + meditateAmount + " life!");
                }                
                checkDeath();
                if (dead)
                {
                    break;
                }
                winCheck();//see if user wins
                if (win)
                {
                    break;
                }
                
                //guard turn
                battleDisplay();
                input.guardAttack();
                System.out.println("\n\t" + guards + " guard/s attack!");
                guardAttack();
                System.out.println("\n\tGuards do " + guardAttack + " damage to Yousir!");
                checkDeath();
                if (dead)
                {
                    break;
                }
                winCheck();//see if user wins
                if (win)
                {
                    break;
                } 
            }
        }
    }
    
    public void winCheck()
    {
        if (guardLife < 1)
        {
            win = true;
            guards = 2.0;
        }
    }
    
    public void fightChoice()
    {
        input.battleDecision();
        
        if (input.battleChoice == 'A')//attack
        {
            userAttack = (random.nextInt(3 - 1) + 1) + userAttackMod;
            guardLife = guardLife - userAttack;
        }
        else if (input.battleChoice == 'B')//meditate
        {
            input.meditate();
            meditateAmount = (random.nextInt(6 - 1) + 1);
            life = life + meditateAmount;
        }
        else
        {
            admin.error();
        }
    }
    
    public void guardAttack()
    {
        guardAttack = (guards * guardAttackMod) + (random.nextInt(2 + 1) - 1);
        life = life - guardAttack;
    }
    
    public void battleDisplay()
    {
        System.out.println("\nTOTAL GUARD LIFE:\t" + guardLife
                         + "\nYOUSIR LIFE:\t\t" + life);
        System.out.println();
    }
    
    public void checkDeath()
    {
        if (life < 1)
        {
            win = false;
            dead = true;
            guards = 2.0;
        }
    }
}
