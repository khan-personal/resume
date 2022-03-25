/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL PROJECT
 */
package hanner_finalproject;

import javax.sound.sampled.LineUnavailableException;

public class GameController 
{   //declare variables
    boolean sacredCup;//wins game
    boolean key;
    boolean club;
    boolean sword;
    boolean brokenSword;
    boolean madChef = false;
    boolean poison;
    boolean trap;
    boolean full;
    int gold;
    double life;
    int aggression;
    int plates;
    
    
    
    Admin admin = new Admin();
    GameView input = new GameView();
    PasswordController password = new PasswordController();
    BesterController dice = new BesterController();
    BattleController battle = new BattleController();
    PasswordView pwvInput = new PasswordView();
    
    //start game
    public void initialize() throws InterruptedException, LineUnavailableException
    {//sets starting values
        sacredCup = false;
        key = false;
        club = false;
        sword = false;
        brokenSword = false;
        poison = false;
        trap = true;
        madChef = false;
        gold = 10;
        life = 10;
        aggression = 0;
        plates = 0;
        
        input.begin = "NO";    
        input.choice = 'D';
        
        
        try
        {
            input.begin();
            if ("YES".equals(input.begin))
            {
                System.out.println(battle.guards);
                crossroads();
            }
            else if ("NO".equals(input.begin))
            {
                admin.goodbye();
                System.exit(0);
            }
            else
            {
                admin.error();
                initialize();
            }
        }
        catch (InterruptedException | LineUnavailableException e)
        {
            admin.error();
        }
    }
    
    public void crossroads() throws InterruptedException, LineUnavailableException
    {   //user arrive at crossroads
        while (input.choice == 'D' && life > 0 && sacredCup == false) 
        {
            configureStats();//configure user stats for GameView
            input.arriveCrossroads();//disp crossroads message

            if (input.choice == 'A') //send to market
            {
                market();
            }
            else if (input.choice == 'B')//send to alley
            {
                alley();
            }
            else if (input.choice == 'C')//send to door
            {
                castleDoor();
            }
            else
            {
                admin.error();//invalid input
                input.choice = 'D';
            }
        }
        
        checkDeath();
        
        while (sacredCup)
        {
            input.winGame();
            input.restart();
            if (input.restart == 'Y')
            {
                initialize();
            }
            else if (input.restart == 'N')
            {
                
            }
            else 
            {
                admin.error();
            }
        }
        
    }
    
    public void market() throws InterruptedException, LineUnavailableException
    {//from crossroads...MARKET()
        configureStats();
        input.arriveMarket();
        while (input.choice == 'A' && life > 0)
        {
            if (input.marketChoice == 'A')//user selects KEY
            {
                if (key)
                {
                    input.alreadyItem();//user has item, don't buy again
                    input.choice = 'D';//back to crossroads
                }
                else if (gold >= 5)//if enough gold
                {
                    gold = gold - 5;//take gold
                    key = true; //acquire key
                    input.acquireKey();
                    input.choice = 'D';//back to crossroads
                }
                else if (gold < 5)//if not enough gold
                {
                    input.lackFunds();//disp not enought funds
                    input.choice = 'D';//back to crossroads
                }
            }
            else if (input.marketChoice == 'B')//user selects CLUB
            {
                if (club)
                {
                    input.alreadyItem();//user has item, don't buy again
                    input.choice = 'D';//back to crossroads
                }
                else if (gold >= 10)//if enough gold
                {
                    gold = gold - 10;//take gold
                    club = true;//acquire club
                    input.acquireClub();
                    input.choice = 'D';//back to crossroads
                }
                else if (gold < 10)//if not enough gold
                {
                    input.lackFunds();//disp not enought funds
                    input.choice = 'D';//back to crossroads
                }    
            }
            else if (input.marketChoice == 'C')//user selects SWORD
            {
                if (sword)
                {
                    input.alreadyItem();//user has item, don't buy again
                    input.choice = 'D';//back to crossroads
                }
                else if (gold >= 20)//if enough gold
                {
                    gold = gold - 20;//take gold
                    sword = true;//aqcuire sword
                    input.acquireSword();
                    input.choice = 'D';//back to crossroads
                }
                else if (gold < 20)//if not enough gold
                {
                    input.lackFunds();//disp not enough funds
                    input.choice = 'D';//back to crossroads
                }
            }
            else if (input.marketChoice == 'D')
            {
                input.runAway();
                input.choice = 'D';
            }
            else
            {
                admin.error();//invalid input
            }
        }
        checkDeath();
    }
    
    public void alley() throws InterruptedException, LineUnavailableException
    {//from crossroads...ALLEY()
        configureStats();
        input.arriveAlley();
        while (input.choice == 'B' && life > 0)
        {
            if (input.alleyChoice == 'A')
            {
                if (gold < 1)
                {//disp if no gold
                    input.beatUp();
                    life = life - 1;
                    input.choice = 'D';
                }
                else
                {//if gold > 0, allow gamble
                    besterGame();
                    gold = gold + dice.result;
                    
                    if (gold < 0 && gold >= -19)
                    {//if user does not have funds for wager (and lost), punish
                        input.noScam();
                        life = life - 3;
                        input.choice = 'D';
                        gold = 0;
                    }
                    else if (gold <= -20)
                    {
                        input.dishonestBet();
                        life = 0;
                        checkDeath();
                    }
                    else
                    {
                        input.choice = 'D';                        
                    }   
                }
            }
            else if (input.alleyChoice == 'B')
            {
                input.runAway();
                input.choice = 'D';
            }
            else
            {
                admin.error();
                alley();
            }
        }
        checkDeath();
    }
    
    public void castleDoor() throws InterruptedException, LineUnavailableException
    {//from crossroads...CASTLEDOOR()
        configureStats();
        input.arriveCastleDoor();
        while (input.choice == 'C' && life > 0)
        {
            if (input.doorChoice == 'A')//key
            {
                doorKey();
            }
            else if (input.doorChoice == 'B')//club
            {
                doorClub();
            }
            else if (input.doorChoice == 'C')//sword
            {
                doorSword();
            }
            else if (input.doorChoice == 'D')//knock
            {
                doorKnock();
            }
            else if (input.doorChoice == 'E')//beg
            {
                doorBeg();
                if (input.choice == 'E')
                {
                    castle();
                }
            }
            else
            {
                admin.error();
                castleDoor();
            }
        }
        
        while (input.choice == 'E')
        {
            castle();//send user to castle
        }
        checkDeath();
    }
    
    public void doorKey()
    {//from crossroads...door...DOORKEY()
        while (input.choice == 'C' && input.doorChoice == 'A' && life > 0)
        {
            if (key)
            {
                input.hasKey();
                input.choice = 'E';
            }
            else
            {
                input.lackItem();
                input.choice = 'D';
            }
        }
    }
    
    public void doorClub() throws InterruptedException, LineUnavailableException
    {//from crossroads...door...DOORCLUB()
        while (input.choice == 'C' && input.doorChoice == 'B' && life > 0)
        {
            if (club)
            {
                input.hasClub();
                aggression = aggression + 4;
                input.choice = 'E';
            }
            else
            {
                input.lackItem();
                input.choice = 'D';
            }
        }
        checkDeath();
    }
    
    public void doorSword() throws InterruptedException, LineUnavailableException
    {//from crossroads...door...DOORSWORD()
        while (input.choice == 'C' && input.doorChoice == 'C' && life > 0)
        {
            if (sword)
            {
                input.hasSword();
                aggression = aggression + 5;
                sword = false;
                brokenSword = true;
                input.choice = 'E';
            }
            else
            {
                input.lackItem();
                input.choice = 'D';
            }
        }
        checkDeath();
    }
    
    public void doorKnock() throws InterruptedException, LineUnavailableException
    {
        while (input.choice == 'C' && input.doorChoice == 'D' && life > 0)
        {   //set to initialize
            password.win = false;
            
            while (!password.win && !password.fail)
            {
                input.doorKnock();//disp knock message
                passwordGame();//play GuessTheWord
                if (password.choice)//user selects not to play game
                {
                    input.doorKnockRun();
                    aggression = aggression + 1;
                    input.choice = 'D';
                    crossroads();
                }
            }                

            if(password.win)//user wins game
            {
                input.passwordTrue();
                input.choice = 'E';
            }
            else if (password.fail)//user loses game
            {
                input.passwordFalse();
                aggression = aggression + 1;
                life = life - 1;
                input.choice = 'D';
            }
        } 
        
        checkDeath();
    }
    
    public void doorBeg() throws InterruptedException, LineUnavailableException
    {//from crossroads...door...DOORBEG()
        while (input.choice == 'C' && input.doorChoice == 'E' && life > 0)
        {
            if (gold == 0 && sword == false)
            {
                input.trueBegger();
                battle.guards = 0;
                input.choice = 'E';
            }
            else if (gold == 0 && sword == true)
            {
                input.suspiciousBegger();
                aggression = aggression + 1;
                input.choice = 'D';
            }
            else
            {
                input.falseBegger();
                life = life - 2;
                aggression = aggression + 1;
                input.choice = 'D';
            }
        }
        checkDeath();
    }
    
    public void castle() throws InterruptedException, LineUnavailableException
    {//from crossroads...door...key/club/sword/knock/beg...CASTLE()
        while (input.choice == 'E' && life > 0)
        {
            configureStats();//initialize stats
            
            input.arriveCastle();
            if (input.castleChoice == 'A')//kitchen
            {
                kitchen();
            }
            else if (input.castleChoice == 'B')//main hall
            {
                mainHall();
            }
            else
            {
                admin.error();
                castle();
            }
        }
        checkDeath();
    }
    
    public void kitchen() throws InterruptedException, LineUnavailableException
    {        
        while (input.choice == 'E' && input.castleChoice == 'A' && life > 0 && !madChef)
        {
            configureStats();
            input.arriveKitchen();
            if (input.kitchenChoice == 'A' && !madChef && !poison && trap) //bribe
            {
                input.bribeChef();
                
                if (gold < input.bribeAmount)//insufficient funds
                {
                    input.oopsBribe();
                    battle.guards = battle.guards + 2;
                    input.castleChoice = 'B';
                    madChef = true;
                }
                else if (input.bribeAmount < 15 && input.bribeAmount <= gold)//bribe too low
                {
                    input.lowBribe();
                    battle.guards = battle.guards + 3;
                    input.castleChoice = 'B';
                    madChef = true;
                }
                else if (input.bribeAmount >= 15 && input.bribeAmount < 35 && input.bribeAmount <= gold)//bribe successful
                {
                    input.successfulBribe();
                    gold = gold - input.bribeAmount;
                    poison = true;
                    battle.guards = 0;
                    input.castleChoice = 'B';
                }                    
                else if (input.bribeAmount >= 35 && input.bribeAmount <= gold)//EXCELLENT bribe, bonus unlocked
                {
                    input.impressiveBribe();
                    gold = gold - input.bribeAmount;
                    poison = true;
                    battle.guards = 0;
                    trap = false;
                    input.castleChoice = 'B';
                }
            }
            else if (input.kitchenChoice == 'A' && madChef || poison || !trap)
            {
                input.goAway();
                input.castleChoice = 'B';
            }
            else if (input.kitchenChoice == 'B' && !madChef)//taste food
            {
                input.tasteFood();
                life = life + 1;
                battle.guards = battle.guards + 3;
                input.castleChoice = 'B';
                madChef = true;
            }
            else if (input.kitchenChoice == 'C')//go to main hall
            {
                input.skipKitchen();
                input.castleChoice = 'B';
            }
            else if (madChef)
            {
                input.madChef();
            }
        }
        
        if (madChef && input.choice == 'E' && input.castleChoice == 'A' && life > 0)
        {
            input.madChef();
        }
        checkDeath();
    }
    
    public void mainHall() throws InterruptedException, LineUnavailableException
    {
        while (input.choice == 'E' && input.castleChoice == 'B' && life > 0)
        {
            configureStats();
            input.arriveMainHall();
            if (input.mainHallChoice == 'A')//eat food at hall
            {
                eatFood();
            }
            else if (input.mainHallChoice == 'B')//go to cup
            {
                configureBattleStats();
                battle();
            }
            else
            {
                admin.error();
            }
        }
    }
    
    public void eatFood() throws InterruptedException, LineUnavailableException
    {
        while (input.mainHallChoice == 'A' && life > 0 && poison == false && plates < 6)
        {
            do
            {//feed user yummy food that gives life
                plates++;
                input.hallFood();
                life = life + 2;
                if (plates == 5)
                {
                    input.allFood();
                    break;
                }
                configureStats();
                input.moreFood();
                if (input.tableChoice == 'B')//user selects main hall
                {
                    input.mainHallChoice = 'B';
                    configureBattleStats();
                    battle();
                }
                
            } while (input.tableChoice == 'A' && 4 >= plates);//user selects to eat more food
            
            
            
            if (plates > 2)
            {//if user eats too much (more than 2), they are full and slow for battle
                full = true;
                input.stuffed();
            }
            
            input.mainHallChoice = 'B';
        }
        while (input.mainHallChoice == 'A' && life > 0 && poison == true && plates < 6)
        {
            do
            {//feed user poisoned food that takes life
                input.poisonedFood();
                life = life - 9;
                plates++;
                configureStats();
                checkDeath();
                if (plates == 5)
                {
                    input.allFood();
                    break;
                }
                input.moreFood();//offer user more poisoned food
                if (input.tableChoice == 'B')//user selects main hall
                {
                    input.mainHallChoice = 'B';
                    configureBattleStats();
                    battle();
                }
            } while (input.tableChoice == 'B' && 4 >= plates);//user selects to eat more food
            
            if (plates > 2)
            {
                full = true;
                input.stuffed();
            }
            
            input.mainHallChoice = 'B';
        }
        
        if (battle.win && input.cupChoice == 'B' && plates < 5 && poison == false)//cup or food, grab food
        {
            plates++;
            input.hallFood();
            life = life + 2;
            grabTheSacredCup();
        }
        
        else if (battle.win && input.cupChoice == 'B' && plates < 5 && poison == true)
        {
            plates++;
            input.poisonedFood();
            life = life - 9;
            checkDeath();
            grabTheSacredCup();
        }
    }
    
    public void grabTheSacredCup() throws InterruptedException, LineUnavailableException
    {
        configureStats();
        input.displayStats();
        
        input.reachForCup();
        if (input.cupChoice == 'A')//grab cup
        {
            if (trap)
            {
                input.trapActivated();
                life = life - 6;
                configureStats();
                trap = false;
                checkDeath();
                grabTheSacredCup();
            }
            else 
            {
                admin.sacredCup();
                input.sacredCup();
                sacredCup = true;
                gameWin();
            }
        }
        else if (input.cupChoice == 'B')//eat food!
        {
            if (plates < 5)//allow eat
            {
                eatFood();
            }
            else//no food left
            {
                input.allFood();//all food gone
                grabTheSacredCup();//try again
            }
        }
        else
        {
            admin.error();
            grabTheSacredCup();
        }
        
        
//        checkDeath();
//        input.sacredCup();
//        sacredCup = true;        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void configureBattleStats()
    {
    //account for aggression        
        if (aggression >= 5)
        {
            input.battleMuchAggression();
            battle.guards = battle.guards + 5;
        }
        else if (aggression > 1 && aggression < 5)
        {
            input.battleSomeAggression();
            battle.guards = battle.guards + 2;
        }
        else if (aggression == 1)
        {
            input.battleLittleAggression();
            battle.guards = battle.guards + 1;
        }
        else if (aggression < 0)
        {
            input.battleNoAggression();
        }

        //account for fullness
        if (full)
        {
            battle.guardAttackMod = 1.3;
            battle.full = true;
        }
        
        //set status as alive
        battle.dead = false;
        
        //account for life
        battle.life = life;
        
        //set win as false
        battle.win = false;

        //account for weapons
        if (sword && club)
        {
            battle.userAttackMod = 3.0;
        }
        else if (sword && !club)
        {
            battle.userAttackMod = 2.5;
        }
        else if (!sword && club)
        {
            battle.userAttackMod = 2.0;
        }
        else if (brokenSword)
        {
            battle.userAttackMod = 1.5;
        }
    }
    
    //start Battle
    public void battle() throws InterruptedException, LineUnavailableException
    {   //BATTLE PROGRAMMING BEGINS
        if (input.mainHallChoice == 'B' && life > 0)
        {            
            //start battle!
            while (!battle.win && !battle.dead)
            {
                battle.initialize();
                life = battle.life;
            }
            
            //configure life after battle
            
            if (battle.dead)
            {                
                checkDeath();
            }

            else if (battle.win)
            {
                input.battleWon();
                grabTheSacredCup();
            }
        }
    }
    
    //start GuessTheWord
    public void passwordGame() throws InterruptedException, LineUnavailableException
    {
        if (!password.fail && !password.win)
        {
            //display intro
            admin.passwordIntro();
            password.initialize();//initilize game
            checkDeath();
        }
    }
    
    //start Bester
    public void besterGame() throws InterruptedException, LineUnavailableException
    {
        admin.besterIntro();//display intro
        dice.game();//initialize game
        checkDeath();
    }
    
    //set user stats for GameView to display
    public void configureStats()
    {
        input.dispGold = Integer.toString(gold);
        input.dispLife = Double.toString(life);
        
        if (key == false && club == false && sword == false && brokenSword == true)
        {
            input.dispItems = "BROKEN SWORD";
        }
        else if (key == true && club == false && sword == false && brokenSword == true)
        {
            input.dispItems = "KEY  BROKEN SWORD";
        }
        else if (key == false && club == true && sword == false && brokenSword == true)
        {
            input.dispItems = " CLUB   BROKEN SWORD";
        }
        else if (key == true && club == true && sword == false && brokenSword == true)
        {
            input.dispItems = "KEY   CLUB   BROKEN SWORD";
        }
        else if (key == false && club == true && sword == true && brokenSword == true)
        {
            input.dispItems = "CLUB   SWORD   BROKEN SWORD";
        }
        else if (key == true && club == false && sword == true && brokenSword == true)
        {
            input.dispItems = "KEY   SWORD   BROKEN SWORD";
        }
        else if (key == true && club == true && sword == true && brokenSword == true)
        {
            input.dispItems = "KEY   CLUB   SWORD   BROKEN SWORD";
        }
        else if (key == false && club == false && sword == false && brokenSword == true)
        {
            input.dispItems = "BROKEN SWORD";
        }
        else if (key == true && club == false && sword == false && brokenSword == false)
        {
            input.dispItems = "KEY";
        }
        else if (key == false && club == true && sword == false && brokenSword == false)
        {
            input.dispItems = "CLUB";
        }
        else if (key == false && club == false && sword == true && brokenSword == false)
        {
            input.dispItems = "SWORD";
        }
        else if (key == true && club == true && sword == false && brokenSword == false)
        {
            input.dispItems = "KEY   CLUB";
        }
        else if (key == false && club == true && sword == true && brokenSword == false)
        {
            input.dispItems = "CLUB   SWORD";
        }
        else if (key == true && club == false && sword == true && brokenSword == false)
        {
            input.dispItems = "KEY   SWORD";
        }
        else if (key == true && club == true && sword == true && brokenSword == false)
        {
            input.dispItems = "KEY   CLUB   SWORD";
        }        
        else
        {
            input.dispItems = "-";
        }
    }
    
    public void checkDeath() throws InterruptedException, LineUnavailableException
    {
        if (life <= 0)
        {
            input.death();//inform user game over
            
            input.restart();//offer restart
            if (input.restart == 'Y')
            {
                input.choice = 'D';
                initialize();
            }
            else if (input.restart == 'N')
            {
                terminateProgram();
            }
            else
            {
                admin.error();
            }
        }
    }
    
    public void gameWin() throws InterruptedException, LineUnavailableException
    {
        if (sacredCup)
        {
            input.winGame();
            input.restart();
            if (input.restart == 'Y')
            {
                battle.guards = 2;
                battle.guardAttackMod = 1.0;
                battle.full = false;
                battle.win = false;
                initialize();                
            }
            else if (input.restart == 'N')
            {
                admin.goodbye();
                System.exit(0);
            }
            else
            {
                admin.error();
                gameWin();
            }
        }
    }
    
    public void terminateProgram() throws LineUnavailableException
    {
        admin.goodbye();
        System.exit(0);
    }
}
