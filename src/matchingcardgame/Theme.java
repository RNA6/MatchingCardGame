/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Theme {
    public static Color color_FF2DD1 = new Color(255, 45, 209);
    public static Color color_CC66DA = new Color(204, 102, 218);
    public static Color color_FDFFB8 = new Color(253, 255, 184);
    public static Color color_63C8FF = new Color(99, 200, 255);
    public static Color color_4DFFBE = new Color(77, 255, 190);
    public static Color color_F3EFEF = new Color(243, 239, 239);
    public static Color color_A19F9F = new Color(161, 159, 159);
    public static String fontName1 = "Comic Sans MS";
    public static String fontName2 = "Monospaced";
    
    public static void setFrameProperties(JFrame frame, int y_location, int frame_hieght){
        frame.getContentPane().setBackground(color_FDFFB8);
        frame.setLocation(300, y_location);
        frame.setPreferredSize(new Dimension(700, frame_hieght));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
    }
}
