/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class SavedLevels extends BaseFrame{

    private JButton ascOrder_button;
    private JButton descOrder_button;
    private JButton back_button;

    private JPanel top_panel;
    private JPanel center_panel;
    private JPanel bottom_panel;
    private JPanel levelsList_panel;
    private ArrayList<JPanel> levels_panels;

    private JScrollPane scrollPane;

    private JLabel head_label;
    private JLabel level_label;
    private JLabel levelId_label;
    private JLabel date_label;
    
    private int rowCount = 0;
    private int levelNumber = 0;
    private int levelId = 0;
    private LocalDate date = LocalDate.now();

    public SavedLevels() {
        super("Saved Levels", 130, 500);

        //Beginning of Top Panel
        createTop_panel();

        //Head Label
        createHead_label();
        top_panel.add(head_label);

        add(top_panel, BorderLayout.NORTH);
        //#End of Header Panel

        //Beginning of Center Panel
        createCenter_panel();
        
        //Beginning of Users List Panel
        levelsList_panel = UIComponents.createScrolling_panel();

        //Levels Panels
        levels_panels = new ArrayList();
        for(int i=0; i<4; i++){
            addNewLevel(i+1, 1111);
        }
        //#End of Levels List Panel
        
        //ScrollPane declaration
        scrollPane = UIComponents.createScrollPane(levelsList_panel);
        center_panel.add(scrollPane);
        
        add(center_panel, BorderLayout.CENTER);
        //#End of Center Panel

        //Beginning of Bottom Panel
        createBottom_panel();

        //Back Button
        createBack_button();

        bottom_panel.add(back_button);
        add(bottom_panel, BorderLayout.SOUTH);
        //#End of Bottom Panel
    }

    //Top Panel Declaration
    private void createTop_panel() {
        top_panel = new JPanel();
        top_panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        top_panel.setOpaque(false);
    }

    //Top Panel Components
    //Head Label Declaration
    private void createHead_label() {
        head_label = new JLabel("Saved Levels");
        head_label.setForeground(UITheme.color_CC66DA);
        head_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 40));
        head_label.setHorizontalAlignment(SwingConstants.CENTER);
    }
    //#End of Top Panel Components

    //Center Panel Declaration
    private void createCenter_panel() {
        center_panel = new JPanel();
        center_panel.setLayout(new BorderLayout());
        center_panel.setOpaque(false);
    }

    //Center Panel Components    
    //Levels Panel Declaration
    private JPanel createLevels_panel() {
        JPanel levels_panel = UIComponents.createContent_panel();
        levels_panel.setLayout(new GridLayout(1, 1));
        levels_panel.setPreferredSize(new Dimension(150, 120));
        levels_panel.add(createSavedLevel_panel());
        levels_panel.putClientProperty("levelNumber", levelNumber);
        assignSavedLevel(levels_panel);
        return (levels_panel);
    }
    
    //Levels Panel Components
    //Level Information Labels Declaration
    private void createLevelInfo_labels() {
        level_label = new JLabel(("Level: " + levelNumber), SwingConstants.LEFT);
        level_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 14));

        levelId_label = new JLabel("Id: " + levelId, SwingConstants.LEFT);
        levelId_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 14));

        date_label = new JLabel("Date: " + date, SwingConstants.LEFT);
        date_label.setFont(new Font(UITheme.fontName1, Font.BOLD, 14));
    }
    
    //Saved Level Information Panel Declaration
    private JPanel createSavedLevel_panel() {
        createLevelInfo_labels();
        JPanel userInfo_panel = new JPanel(new GridLayout(3, 1));
        userInfo_panel.setOpaque(false);
        userInfo_panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        userInfo_panel.add(level_label);
        userInfo_panel.add(levelId_label);
        userInfo_panel.add(date_label);
        return (userInfo_panel);
    }
    //#End of Levels Panel Components
    //#End of Center Panel Components
    
    //Bottom Panel Declaration
    private void createBottom_panel() {
        bottom_panel = new JPanel();
        bottom_panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bottom_panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
        bottom_panel.setOpaque(false);
    }

    //Bottom Panel Components
    //Back Button Declaration
    private void createBack_button() {
        back_button = new JButton("Back");
        back_button.setFocusable(false);
        back_button.setBackground(UITheme.color_4DFFBE);
        back_button.setFont(new Font(UITheme.fontName1, Font.BOLD, 20));
        back_button.setPreferredSize(new Dimension(100, 40));
        back_button.setHorizontalAlignment(SwingConstants.CENTER);
    }
    //#End of Bottom Panel Components
    
    private void increaseLevelsListPanel_size(){
        if(rowCount++ == 0){
            levelsList_panel.setPreferredSize(new Dimension(levelsList_panel.getPreferredSize().width, (levelsList_panel.getPreferredSize().height+ 140)));
        }
        else if(rowCount == 3){
            rowCount = 0;
        }
    }
    
    private void assignSavedLevel(JPanel level_panel){
        int level = (int)level_panel.getClientProperty("levelNumber");
            level_panel.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    level_panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
                    dispose();
                    if(level >=1 && level<=5){
                        Frames.easyLevel[level-1].setVisible(true);
                        Frames.easyLevel[level-1].restartLevel();
                    }
                    else if(level >=6 && level<=10){                        
                        Frames.normalLevel[level-6].setVisible(true);
                        Frames.easyLevel[level-1].restartLevel();
                    }
                    else if(level >=11 && level<=15){
                        Frames.hardLevel[level-11].setVisible(true);
                        Frames.easyLevel[level-1].restartLevel();
                    }
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                    level_panel.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
                } 
                
                @Override
                public void mouseExited(MouseEvent e) {
                    level_panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
                } 
            });
    }
    
    public void addNewLevel(int levelNumber, int levelId){
        this.levelNumber = levelNumber;
        this.levelId = levelId;
        date = LocalDate.now();
        
        JPanel level_panel = createLevels_panel();
        levels_panels.add(level_panel);
        
        increaseLevelsListPanel_size();
        levelsList_panel.add(level_panel);
    }
    
    public JButton getBack_button() {
        return back_button;
    } 

    public ArrayList<JPanel> getLevels_panels() {
        return levels_panels;
    }
}
