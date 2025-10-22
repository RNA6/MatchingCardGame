/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Box;


public class ShowScore extends JFrame{
    private String name="";
    private int score=0;
    JLabel lbl = new JLabel("Congratulations '"+name+"' Your Score is : "+score+" Points");
    
    JButton againButton = new JButton("Try again");
    JButton okButton = new JButton("Ok");
    
    public ShowScore(){
        super("Score");
        setLayout(new BorderLayout());
        Theme.setFrameProperties(this, 130, 500);
        
        lbl.setFont(new Font(Theme.fontName1, Font.BOLD, 28));
        lbl.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        lbl.setForeground(Theme.color_CC66DA);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbl, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 70, 0));
        
        againButton.setFont(new Font(Theme.fontName2, Font.BOLD, 20));
        againButton.setBackground(Theme.color_4DFFBE);
        againButton.setFocusable(false);
        againButton.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(againButton);
        
        buttonPanel.add(Box.createHorizontalStrut(100));
        
        okButton.setFont(new Font(Theme.fontName2, Font.BOLD, 20));
        okButton.setBackground(Theme.color_63C8FF);
        okButton.setFocusable(false);
        okButton.setPreferredSize(new Dimension(80, 50));
        buttonPanel.add(okButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
}
