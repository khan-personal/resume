/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL PROJECT
 */
package hanner_finalproject;

import javax.sound.sampled.LineUnavailableException;

public class Admin 
{
    SoundUtils beep = new SoundUtils();
    
    public void welcome()
    {//castle art taken from https://www.asciiart.eu/buildings-and-places/castles
        System.out.println("Welcome to....\n" +
"                                                  !_\n" +
"                                                  |*~=-.,\n" +
"                                                  |_,-'`\n" +
"                                                  |\n" +
"    THE SEARCH FOR THE SACRED CUP                 |\n" +
"                                                 /^\\\n" +
"                   !_                           /   \\\n" +
"                   |*`~-.,                     /,    \\\n" +
"                   |.-~^`                     /#\"     \\\n" +
"                   |                        _/##_   _  \\_\n" +
"              _   _|  _   _   _            [ ]_[ ]_[ ]_[ ]\n" +
"             [ ]_[ ]_[ ]_[ ]_[ ]            |_=_-=_ - =_|\n" +
"           !_ |_=_ =-_-_  = =_|           !_ |=_= -    |\n" +
"           |*`--,_- _        |            |*`~-.,= []  |\n" +
"           |.-'|=     []     |   !_       |_.-\"`_-     |\n" +
"           |   |_=- -        |   |*`~-.,  |  |=_-      |\n" +
"          /^\\  |=_= -        |   |_,-~`  /^\\ |_ - =[]  |\n" +
"      _  /   \\_|_=- _   _   _|  _|  _   /   \\|=_-      |\n" +
"     [ ]/,    \\[ ]_[ ]_[ ]_[ ]_[ ]_[ ]_/,    \\[ ]=-    |\n" +
"      |/#\"     \\_=-___=__=__- =-_ -=_ /#\"     \\| _ []  |\n" +
"     _/##_   _  \\_-_ =  _____       _/##_   _  \\_ -    |\\\n" +
"    [ ]_[ ]_[ ]_[ ]=_0~{_ _ _}~0   [ ]_[ ]_[ ]_[ ]=-   | \\\n" +
"    |_=__-_=-_  =_|-=_ |  ,  |     |_=-___-_ =-__|_    |  \\\n" +
"     | _- =-     |-_   | ((* |      |= _=       | -    |___\\\n" +
"     |= -_=      |=  _ |  `  |      |_-=_       |=_    |/+\\|\n" +
"     | =_  -     |_ = _ `-.-`       | =_ = =    |=_-   ||+||\n" +
"     |-_=- _     |=_   =            |=_= -_     |  =   ||+||\n" +
"     |=_- /+\\    | -=               |_=- /+\\    |=_    |^^^|\n" +
"     |=_ |+|+|   |= -  -_,--,_      |_= |+|+|   |  -_  |=  |\n" +
"     |  -|+|+|   |-_=  / |  | \\     |=_ |+|+|   |-=_   |_-/\n" +
"     |=_=|+|+|   | =_= | |  | |     |_- |+|+|   |_ =   |=/\n" +
"     | _ ^^^^^   |= -  | |  <&>     |=_=^^^^^   |_=-   |/\n" +
"     |=_ =       | =_-_| |  | |     |   =_      | -_   |\n" +
"     |_=-_       |=_=  | |  | |     |=_=        |=-    |\n" +
"^^^^^^^^^^`^`^^`^`^`^^^\"\"\"\"\"\"\"\"^`^^``^^`^^`^^`^`^``^`^``^``^^");
        System.out.println("\n\nIn this game, you will make decisions for a character"
                         + "\nnamed: YOUSIR (pronounced User). Yousir is searching"
                         + "\nfor a Sacred Cup that is rumored to bring great luck"
                         + "\nto those who posess it."
                         + "\n\nWhen Yousir is presented with a choice, you get to"
                         + "\ndecide what they do by choosing one of the options in"
                         + "\nthe [brackets] and pressing the Enter button on your"
                         + "\nkeyboard. Yousir will be assigned 10 life and 10 gold"
                         + "\nat the beginning of the game. The more Yousir aggrivates"
                         + "\nthe guards, the more of them will be guarding the Sacred"
                         + "\nCup. Good luck!"
                            + "\n\n\tHint:\tBarging in with a sword and fighting"
                            + "\n\t\tthrough is the hardest way to win...");
    }
    
    public void besterIntro() throws LineUnavailableException
    {   //intro image, taken from https://ascii.co.uk/art/beard 
        //and slightly adjusted to be more disfigured and menacing
        System.out.println("\n\n" +
"        ______________________                                   \n" +
"     .-'                      '-.                                \n" +                
"    /   '-.               .-'    \\                              \n" +
"   /_______'-._________.-'________\\                             \n" +
"  |        _   '-. .-'   _        |                              \n" +
"  |       (o)  /     \\  (o)       |        ____________         \n" +
"  |'-.        /       \\        .-'|       /Let's      /         \n" +
"  |   '-.____/         \\____.-'   |      /  gamble.../          \n" +
"  |          \\_ _v_v_ _/          |    </___________/           \n" +
"  |      //////////\\\\\\\\\\\\\\\\\\      |                     \n" +
"  |     ///////////\\\\\\\\\\\\\\\\\\\\     |                    \n" +
"  |  Q |||| .-----------._|||| Q  |                              \n" +
"  |   \\|||| '-|_|_|___|-' ||||/   |                             \n" +
"  |     \\\\\\  '-|--|-|-|'  ///     |                           \n" +
"   \\     \\\\\\|||||||||||||///     /                           \n" +
"    \\      \\\\\\\\\\\\\\\\///////      /                       \n" +
"     \\       \\\\\\\\\\\\/////       /                          \n" +
"      \\_______________________/                                   ");
        beep.alert();
        //rules
        System.out.println("\n\nAs Yousir enters the dark alley, they notice a"
                         + "\nsuspicious character approach them with dice in"
                         + "\ntheir hand. The suspicious character would like to"
                         + "\ngamble Yousir for their gold on a game of dice..."
                         + "\n\nEach player receives 5 dice and 2 opportunities to"
                         + "\nroll. If Yousir chooses not to roll after Round 1,"
                         + "\nYousir's winnings could double! But the suspicious"
                         + "\ncharacter will still get to roll a second time."
                         + "\nThe player with the highest score wins."
                         + "\n\nIt looks like they will let Yousir wager more gold"
                         + "\nthan Yousir has... but they also look violent."
                         + "\nBe careful...");
    }
    
    
    //intro for GuessTheWord game to unlock door/password prompt
    public void passwordIntro() throws LineUnavailableException
    {   //intro image, taken from https://ascii.co.uk/art/helmet
        System.out.println("\n\n\n"+
"                   _                       \n" +
"                ,''/., _                   \n" +
"        `.-._\\`/. ( //'/'`.               \n" +
"      _.-`-. ``' ` `(   -. \\              \n" +
"    ,'  ,    ,-:._ _..-.. \\/              \n" +
"   / ,'/ ,`.( _.'-'.     )/                \n" +
"   `.\\ '(   ,'      `.                    \n" +
"      `._\\ /'       \\ \\                 \n" +
"          /:         \\ \\-.               \n" +
"        ,;':._______...-'_)      ____________  \n" +
"        \\:/-.._______..-_|     /           /  \n" +
"         : :\\   `----'|'-;    / Password? /   \n" +
"          \\ :\\    : : ;:/  </___________/    \n" +
"           \\ ``.   ; /;/                      \n" +
"            )   `.  /,'                    \n" +
"          ,'      `-' \\                   \n" +
"         /  .--.       )                   \n" +
"        /_.---._`._   /                    \n" +
"                `.__.'");
        //beeps
        beep.alert();
        //rules
        System.out.println("\nAs Yousir knocks on the door, a knight appears and"
                         + "\nasks for a password. Yousir thinks they may be able"
                         + "\nto spell it out, but will only have 4 wrong guesses"
                         + "\nbefore the guard realizes that Yousir is guessing...");        
    }
    
    public void battleIntro()
    {//taken and adapted from https://ascii.co.uk/art/fight
        System.out.println("\n" + 
"             Y\n" +
"             |      .\n" +
"             +._ O /\n" +
"             |  `#'\n" +
"             |  / \\\n" +
"                ())\n" +
"                d b\n" +
"\n" +
"                                      p\n" +
"                                   .-/-o\n" +
"                                  / /'\n" +
"                             .--./ /     --------<\n" +
"                                 O'-._\n" +
"                                      `\n\n" +
"\t\tPREPARE FOR BATTLE!");
    }
    
    public void sacredCup()
    { //taken and heavily adapted from https://ascii.co.uk/art/cup
        System.out.println("\n" +
"     *      *      *  . *   *   *     *\n" +
"           *     *      `:.*      *\n" +
"        *    *        *   `:. *     *\n" +
"      *     *     .:'     ,::    *\n" +
"         *    *  .:'      ;:'*     *\n" +
"          *      :: *    ;:'      *\n" +
"         *   *    :    .:'    *\n" +
"            *     *`.  :.*  *    *\n" +
"        #############################\n" +
"       #  _________________________  #\n" +
"       # : _ _ _ _ _ _ _ _ _ _ _ _ : #\n" +
"       # :\".\".\".\".\".\".\".\".\".\".\".\".\": #\n" +
"       # `::.:.:.:.:.:.:.:.:.:.:.::' #\n" +
"        # `:-===-===-===-===-===-:' #\n" +
"          # :                   : #\n" +
"           # `.               ,' #\n" +
"             # \\,,,,,,,,,,,,,/ #\n" +
"              # |           | #\n" +
"              # |           | #\n" +
"              # |           | #\n" + 
"              # |           | #\n" +
"              # |,,,,,,,,,,,| #\n" +
"              # /           \\ #\n" +
"             # /_____________\\ #\n" +
"            #####################");
    }
    
    public void goodbye() throws LineUnavailableException
    {
        System.out.println("\n\n\tThank you for playing!");
        //beep.flea();
    }
    
    public void error()
    {
        System.out.println("\tI don't understand, try again.");
    }
}
