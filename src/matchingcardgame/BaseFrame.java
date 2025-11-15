/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author RNA
 */
public class BaseFrame extends JFrame{
    
    private JFrame previousFrame;
    
    public BaseFrame(String title, int y_location, int frame_hieght){
        super(title);
        getContentPane().setBackground(UITheme.color_FDFFB8);
        setLocation(300, y_location);
        setPreferredSize(new Dimension(700, frame_hieght));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public JFrame getPreviousFrame() {
        return previousFrame;
    }

    public void setPreviousFrame(JFrame previousFrame) {
        this.previousFrame = previousFrame;
    }
    
    
}
