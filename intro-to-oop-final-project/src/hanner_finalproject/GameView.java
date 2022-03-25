/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL PROJECT
 */
package hanner_finalproject;

import java.util.Scanner;

public class GameView 
{
    String begin = "NO";    
    char choice = 'D';
    char marketChoice;
    char alleyChoice;
    char doorChoice;
    char castleChoice;
    char kitchenChoice;
    int bribeAmount;
    char mainHallChoice;
    char tableChoice;
    char battleChoice;
    char cupChoice;
    String dispGold;
    String dispLife;
    String dispItems;
    char restart;
        
    Scanner keyboard = new Scanner(System.in);
    
    
    public void begin()
    {//ask to begin game
        System.out.println("\nWould you like to begin? [YES] or [NO]");
        begin = keyboard.next().toUpperCase();
    }
    
    public void displayStats()
    {//display user stats
        System.out.println("\nYOUSIR STATS*************************************"
                         + "\n\tGOLD:\t" + dispGold
                         + "\n\tLIFE:\t" + dispLife
                         + "\n\tITEMS:\t" + dispItems
                         + "\n*************************************************");
    }
    
    public void arriveCrossroads()
    {//display as user arrives to crossroads
        System.out.println("\nYousir arrives at a cross roads. To their right is a"
                         + "\nmarket, to the left a dark alley, and straight ahead"
                         + "\nis a castle door.");
        System.out.println("\nTravel to: [A] MARKET  [B] ALLEY  [C] CASTLE DOOR");
        displayStats();
        choice = keyboard.next().charAt(0);
        choice = Character.toUpperCase(choice);
    }
    
    public void arriveMarket()
    {//display as user arrives to market
        System.out.println("\nYousir arrives at the market and finds some items"
                + "\nfor sale...");
        System.out.println("\n[A] KEY (5 gold)  [B] CLUB (10 gold)  [C] SWORD (20 gold)"
                         + "\n[D] RUN AWAY...");
        displayStats();
        marketChoice = keyboard.next().charAt(0);
        marketChoice = Character.toUpperCase(marketChoice);
    }
    
    public void arriveAlley()
    {//display as user arrives to alley
        System.out.println("\nAs Yousir approaches the alley, they see a group of"
                + "\nviolent looking gamblers who will not like if Yousir does not"
                + "\nhave any gold...");
        System.out.println("\n[A] CONTINUE  [B] RUN AWAY");
        displayStats();
        alleyChoice = keyboard.next().charAt(0);
        alleyChoice = Character.toUpperCase(alleyChoice);
    }
    
    public void arriveCastleDoor()
    {//display as user arrives to door
        System.out.println("\nYousir approaches the Castle Door. What should they do?");
        System.out.println("[A] USE KEY [B] USE CLUB [C] USE SWORD [D] KNOCK [E] BEG");
        displayStats();
        doorChoice = keyboard.next().charAt(0);
        doorChoice = Character.toUpperCase(doorChoice);
    }
    
    public void arriveCastle()
    {
        System.out.println("\nYousir finds themselves in the castle. They note a"
                         + "\nkitchen to the right and the Main Hall to the left...");
        System.out.println("\n[A] GO TO KITCHEN  [B] GO TO MAIN HALL");
        displayStats();
        castleChoice = keyboard.next().charAt(0);
        castleChoice = Character.toUpperCase(castleChoice);
    }
    
    public void arriveKitchen()
    {
        System.out.println("\nYousir meets the Discontent Chef preparing the next"
                         + "\nmeal for the guards. The Discontent Chef wants to"
                         + "\nquit tonight but they cannot afford a horse (15 gold)"
                         + "\nto move to the next town. If the Discontent Chef also"
                         + "\nhad startup money for a new kitchen (20 gold) in the"
                         + "\nnext town, they would be set for life.");
        System.out.println("\nShould Yousir..."
                         + "\n[A] BRIBE CHEF  [B] TASTE FOOD  [C] GO TO MAIN HALL");
        displayStats();
        kitchenChoice = keyboard.next().charAt(0);
        kitchenChoice = Character.toUpperCase(kitchenChoice);
    }
    
    public void arriveMainHall()
    {
        System.out.println("\nAs Yousir enters the Main Hall, they notice a few"
                         + "\nleftover plates in the corner with some food. If"
                         + "\nYousir is low on life, this may help restore it.");
        System.out.println("\n[A] EAT FOOD  [B] CONTINUE FORWARD TO THE SACRED CUP");
        displayStats();
        mainHallChoice = keyboard.next().charAt(0);
        mainHallChoice = Character.toUpperCase(mainHallChoice);
    }
    
    public void acquireKey()
    {//display if user buys key
        System.out.println("\tYousir has purchased a key and heads back to the crossroads."
                            + "\n\t(-5 gold)");
    }
    
    public void hasKey()
    {//display if user has key and opens door with it
        System.out.println("\n\tThe door quietly opens and Yousir walks in without"
                         + "\n\tbeing noticed...");
    }
    
    public void acquireClub()
    {//display if user buys club
        System.out.println("\tYousir has purchased a club and heads back to the crossroads."
                            + "\n\t(-10 gold)");
    }
    
    public void hasClub()
    {//display if user has club and opens door with it
        System.out.println("\n\tYousir SMASHES the door with their club and it"
                         + "\n\tbursts open on the first swing. The guards"
                         + "\n\theard...");
    }
    
    public void acquireSword()
    {//display if user buys sword
        System.out.println("\tYousir has purchased a swordand heads back to the crossroads."
                       + "\n\t(-20 gold)");
    }
    
    public void hasSword()
    {//display if user has sword and opens door with it
        System.out.println("\n\tYousir swings and swings at the door with their"
                         + "\n\tsword, eventually able to break through. The sword"
                         + "\n\tis now damaged and the guards are aware there is"
                         + "\n\tan intruder in the castle.");
    }
    
    public void doorKnock()
    {//display if user knocks on door
        System.out.println("\nYousir approaches the door and knocks. From above, a"
                         + "\nguard appears...");
    }
    
    public void doorKnockRun()
    {
        System.out.println("\nYousir runs away from the guard while they are talking."
                         + "\nThe guard notes this suspicious behavior...");
    }
    
    public void passwordTrue()
    {
        System.out.println("\nThe guard apoligizes to Yousir and opens the door.");
    }
    
    public void passwordFalse()
    {
        System.out.println("\nThe guard gets suspicious as Yousir continues to"
                         + "\nto guess the password letter by letter... the guard"
                         + "\nknocks Yousir to the ground and tells Yousir to get"
                         + "\nlost.");
        System.out.println("\n\t(-1 life)");
        System.out.println("\n\t(the guards note the suspicious activity)");
    }
        
    public void runAway()
    {//display if user runs away
        System.out.println("\n\tYousir runs back to the safety of the crossroads.");
    }
    
    public void beatUp()
    {//if user has no gold and tries to gamble, lose a life
        System.out.println("\n\tThe deviants in the alley notice your empty coin"
                         + "\n\tpurse, beat you up, and tell you to get lost.");
        System.out.println("\n\t(-1 life)");
    }
    
    public void noScam()
    {//display if user does not have enough gold to cover the wager (if they lost, no consequence if they won)
        System.out.println("\n\tThe deviant gamblers empty Yousir's coin purse and"
                         + "\n\tdiscover Yousir does not have enough to cover the"
                         + "\n\twager. The deviant gamblers beat Yousir up.");
        System.out.println("\n\t(-3 life)");
    }
    
    public void dishonestBet()
    {
        System.out.println("\nThe Gambler notices Yousir doesn't have nearly enough"
                         + "\nto cover the debt. The Gambler makes sure everyone"
                         + "\nknows not to cheat them...");
        System.out.println("\n\tYousif is not heard from again...");
    }
    
    public void lackFunds()
    {//display if user does not have enough gold
        System.out.println("\n\tYousir lacks the funds for this purchase.");
    }
    
    public void lackItem()
    {//display if user does not have required item
        System.out.println("\n\tYousir lacks the item for this action.");
    }
    
    public void alreadyItem()
    {
        System.out.println("\n\tYousir already has this item...");
    }
    
    public void trueBegger()
    {//display if gold == 0
        System.out.println("\n\tYou look like you've had it pretty rough, come on"
                         + "\n\tin and have some food while you warm up."
                         + "\n\tJust head over to the Main Hall and we will take"
                         + "\n\tcare of you.");
        System.out.println("\nYousir notices many guards leaving the castle going"
                         + "\nto help other beggars in the village.");
    }
    
    public void falseBegger()
    {//display if gold > 0
        System.out.println("\n\tWe can see gold in your purse, you have no business"
                         + "\n\tbegging here, get lost!");
        System.out.println("\n\t(-2 life)"
                         + "\n\t(the guards note the suspicious activity)");
    }
    
    public void suspiciousBegger()
    {
        System.out.println("\nThe guards point out that Yousir's sword is not"
                         + "\nsomething a beggar usually carries around...");
        System.out.println("\n\t(the guards note the suspicious activity)");
    }
    
    public void battleNoAggression()
    {
        System.out.println("\nYousir was able to enter the castle without alerting"
                         + "\nthe guards. The castle has not reinforced the guards"
                         + "\nin the Main Hall.");
        System.out.println("\n\t(+0 guards)");
    }
    
    public void battleLittleAggression()
    {
        System.out.println("\nYousir's presence created some suspicion with the"
                         + "\nguards. The guards have reinforced the Main Hall.");
        System.out.println("\n\t(+1 guard)");
    }
    
    public void battleSomeAggression()
    {
        System.out.println("\nYousir's presence has created a disturbance in the"
                         + "\ncastle. The guards have reinforced the Main Hall.");
        System.out.println("\n\t(+2 guards)");
    }
    
    public void battleMuchAggression()
    {
        System.out.println("\nYousir's entrance made so much of a disturbance that"
                         + "\nthe castle called in reinforcements from another"
                         + "\nvillage. Expect many guards in the Main Hall.");
        System.out.println("\n\t(+5 guards)");
    }
    
    public void bribeChef()
    {
        System.out.println("\nHow much would you like to offer the Discontent Chef"
                         + "\nas a bribe? Too little and they may get angry...");
        System.out.println("ENTER BRIBE AMOUNT:");
        bribeAmount = keyboard.nextInt();
    }
    
    public void goAway()
    {
        System.out.println("\nThe Chef is too busy to deal with you again.");
    }
    
    public void oopsBribe()
    {
        System.out.println("\nYousir offers the bribe, but realizes there is not"
                         + "\nenough gold to cover the bribe... the Discontent Chef"
                         + "\nis not pleased by this deception and calls for the"
                         + "\nguards. Yousir escapes to the Main Hall...");
        System.out.println("\nYousir can hear several guards running to the"
                         + "\nMain Hall to guard the Sacred Cup.");
    }
    
    public void lowBribe()
    {
        System.out.println("\nThe Discontent Chef laughs at Yousir's insufficent"
                         + "\nbribe and calls for the guards. Yousir runs out of"
                         + "\nthe kitchen.");
        System.out.println("\nYousir can hear several guards running to the"
                         + "\nMain Hall to guard the Sacred Cup.");
    }
    
    public void successfulBribe()
    {
        System.out.println("\nThe Discontent Chef quickly grabs the bribe and starts"
                         + "\nadding unusual ingredients to the food... they tell"
                         + "\nYousir not to worry about the guard/s as Yousir makes"
                         + "\ntheir way to the Main Hall.");
    }
    
    public void impressiveBribe()
    {
        System.out.println("\nThe Discontent Chef quickly grabs the enormous bribe"
                         + "\nand starts adding unusual ingredients to the food."
                         + "\nAs Yousir leaves the kitchen, the Discontent Chef"
                         + "\nwarns Yousir not to eat the food, and to watch out"
                         + "\nfor the trap guarding the Sacred Cup.");
    }
    
    public void tasteFood()
    {
        System.out.println("\nAs Yousir grabs a handful of mashed potatoes from"
                         + "\nfrom the pot, the Chef screams at Yousir and chases"
                         + "\nYousir out of the Kitchen in to the Main Hall. The"
                         + "\nquick bite Yousir got of the food was delicious!");
        System.out.println("\t\n(+1 life)"
                         + "\nYousir can hear several guards running to the"
                         + "\nMain Hall to guard the Sacred Cup.");
    }
    
    public void madChef()
    {
        System.out.println("\nYousir already upset the chef... they shouldn't try"
                         + "\nto upset the chef further...");
    }
    
    public void skipKitchen()
    {
        System.out.println("\nYousir decides to head straight for the Main Hall.");
    }
    
    public void hallFood()
    {
        System.out.println("\nYousir admires the texture of the food, this chef"
                         + "\nreally knows what they are doing.");
        System.out.println("\n\tYousir feels stronger."
                         + "\n\t(+2 life)");
    }
    
    public void moreFood()
    {
        System.out.println("\nShould Yousir eat more food?");
        System.out.println("\n[A] EAT MORE FOOD  [B] CONTINUE FORWARD TO THE SACRED CUP");
        displayStats();
        tableChoice = keyboard.next().charAt(0);
        tableChoice = Character.toUpperCase(tableChoice);
    }
    
    public void allFood()
    {
        System.out.println("\nThere is no more food left.");
    }
    
    public void stuffed()
    {
        System.out.println("\nYousir feels sluggish after eating too much food.");
        System.out.println("Yousir will take more damage from guards if they battle.");
    }
    
    public void poisonedFood()
    {
        System.out.println("\nYousir notices the food tastes funny...");
        System.out.println("\nYousir feels weak."
                         + "\n(-9 life)");
    }
    
    public void death()
    {
        System.out.println("\nYousir slumps over and wonders if less violent"
                         + "\ndecisions would have worked better...");
        System.out.println("\nGAME OVER");
    }
    
    public void restart()
    {
        System.out.println("\n\nWould you like to restart the game? [Y] or [N]");
        restart = keyboard.next().charAt(0);
        restart = Character.toUpperCase(restart);                
    }
    
    //battle set
    
    public void startBattle()
    {
        System.out.println("Yousir will get the first attack in.");
    }
    
    public void startFullBattle()
    {
        System.out.println("Beacuse Yousir ate too much food the guard/s will get"
                         + "\nto attack first.");
    }
    
    public void battleLost()
    {
        System.out.println("\n\tThe guard/s overwhelmed Yousir...");
    }
    
    public void battleWon()
    {
        System.out.println("\n\tYousir emerges victorious from battle!");
    }
    
    public void battleDecision()
    {
        System.out.println("\nWhat should Yousir do?"
                         + "\n[A] ATTACK  [B] MEDITATE");
        battleChoice = keyboard.next().charAt(0);
        battleChoice = Character.toUpperCase(battleChoice);
    }
    
    public void guardAttack()
    {
        System.out.println("\nThe guard/s attack!");
    }
    
    public void noGuards()
    {
        System.out.println("\nThere aren't any guards in the Main Hall..."
                         + "\nIt seems... Yousir won? Yousir presses on.");
    }
    
    public void attack()
    {
        System.out.println("\nYousir attacks!");
    }
    
    public void meditate()
    {
        System.out.println("\nYousir enters a deep meditative trance...");
    }
    public void trapActivated()
    {
        System.out.println("\nYousir hears a sound but before they can turn to"
                         + "\nlook an arrow hits them.");
        System.out.println("\n\tThe trap is spent now, but Yousir looses life."
                         + "\n\t(-6 life)");
    }
    
    public void reachForCup()
    {
        System.out.println("\nYour sees the Sacred Cup within reach. What should"
                         + "\nthey do?");
        System.out.println("\n[A] GRAB SACRED CUP  [B] EAT FOOD");
        cupChoice = keyboard.next().charAt(0);
        cupChoice = Character.toUpperCase(cupChoice);
    }
    
    public void sacredCup()
    {
        System.out.println("\nYousir approaches the Sacred Cup, grabs it, puts it"
                         + "\nin their bag and heads home. Yousir places the"
                         + "\nSacred Cup on their mantle and lives happily ever"
                         + "\nafter...");
    }
    
    
    
    public void winGame()
    {
        System.out.println("\n\tCONGRATULATIONS, YOU WON THE GAME!");
    }
    
}
