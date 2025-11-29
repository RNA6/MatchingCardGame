/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

/**
 *
 * @author RNA
 */
public class Levels {
    private final static String level1_title = "Level 1";
    private final static int level1_totalSeconds = 300;
    private final static int level1_totalCards = 4;
    
    private final static String level2_title = "Level 2";
    private final static int level2_totalSeconds = 300;
    private final static int level2_totalCards = 6;
    
    private final static String level3_title = "Level 3";
    private final static int level3_totalSeconds = 300;
    private final static int level3_totalCards = 8;
    
    private final static String level4_title = "Level 4";
    private final static int level4_totalSeconds = 300;
    private final static int level4_totalCards = 12;
    
    private final static String level5_title = "Level 5";
    private final static int level5_totalSeconds = 300;
    private final static int level5_totalCards = 16;
    
    private final static String level6_title = "Level 6";
    private final static int level6_totalSeconds = 300;
    private final static int level6_totalCards = 12;
        //Stopped here
    private final static String level7_title = "Level 7";
    private final static int level7_totalSeconds = 300;
    private final static int level7_totalCards = 16;
    
    private final static String level8_title = "Level 8";
    private final static int level8_totalSeconds = 300;
    private final static int level8_totalCards = 20;
    
    private final static String level9_title = "Level 9";
    private final static int level9_totalSeconds = 300;
    private final static int level9_totalCards = 24;
    
    private final static String level10_title = "Level 10";
    private final static int level10_totalSeconds = 300;
    private final static int level10_totalCards = 28;
    
    private final static String level11_title = "Level 11";
    private final static int level11_totalSeconds = 300;
    private final static int level11_totalCards = 12;
        //Stopped here
    private final static String level12_title = "Level 12";
    private final static int level12_totalSeconds = 300;
    private final static int level12_totalCards = 16;
    
    private final static String level13_title = "Level 13";
    private final static int level13_totalSeconds = 300;
    private final static int level13_totalCards = 20;
    
    private final static String level14_title = "Level 14";
    private final static int level14_totalSeconds = 300;
    private final static int level14_totalCards = 24;
    
    private final static String level15_title = "Level 15";
    private final static int level15_totalSeconds = 300;
    private final static int level15_totalCards = 28;
    
    public static Level createLevel1(){
        Level level1 = new Level(level1_title, level1_totalSeconds, level1_totalCards);
        return(level1);
    }
    
    public static Level createLevel2(){
        Level level2 = new Level(level2_title, level2_totalSeconds, level2_totalCards);
        return(level2);
    }
    
    public static Level createLevel3(){
        Level level3 = new Level(level3_title, level3_totalSeconds, level3_totalCards);
        return(level3);
    }
    
    public static Level createLevel4(){
        Level level4 = new Level(level4_title, level4_totalSeconds, level4_totalCards);
        return(level4);
    }
    
    public static Level createLevel5(){
        Level level5 = new Level(level5_title, level5_totalSeconds, level5_totalCards);
        return(level5);
    }
    
    public static Level createLevel6(){
        Level level6 = new Level(level6_title, level6_totalSeconds, level6_totalCards);
        return(level6);
    }
    
    public static Level createLevel7(){
        Level level7 = new Level(level7_title, level7_totalSeconds, level7_totalCards);
        return(level7);
    }
    
    public static Level createLevel8(){
        Level level8 = new Level(level8_title, level8_totalSeconds, level8_totalCards);
        return(level8);
    }
    
    public static Level createLevel9(){
        Level level9 = new Level(level9_title, level9_totalSeconds, level9_totalCards);
        return(level9);
    }
    
    public static Level createLevel10(){
        Level level10 = new Level(level10_title, level10_totalSeconds, level10_totalCards);
        return(level10);
    }
    
    
    public static Level createLevel11(){
        Level level11 = new Level(level11_title, level11_totalSeconds, level11_totalCards);
        return(level11);
    }
    
    public static Level createLevel12(){
        Level level12 = new Level(level12_title, level12_totalSeconds, level12_totalCards);
        return(level12);
    }
    
    public static Level createLevel13(){
        Level level13 = new Level(level13_title, level13_totalSeconds, level13_totalCards);
        return(level13);
    }
    
    public static Level createLevel14(){
        Level level14 = new Level(level14_title, level14_totalSeconds, level14_totalCards);
        return(level14);
    }
    
    public static Level createLevel15(){
        Level level15 = new Level(level15_title, level15_totalSeconds, level15_totalCards);
        return(level15);
    }
}
