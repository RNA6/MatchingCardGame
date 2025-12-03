/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

/**
 *
 * @author fadak
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer {

    private Timer levelTimer;
    private final int totalSeconds;
    private int secondsLeft;
    private JLabel timerLabel;
    private Runnable onTimeUp;
    
    private Level level;
    
    private boolean solved;

    public GameTimer(JLabel timerLabel, int totalSeconds, Runnable onTimeUp) {
        this.totalSeconds = totalSeconds;
        this.secondsLeft = totalSeconds;
        this.timerLabel = timerLabel;
        this.onTimeUp = onTimeUp;
        setLevelTimer();
        solved = false;
    }
    
    private void setLevelTimer(){
        levelTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(solved){
                    levelTimer.stop();
                    return;
                }
                secondsLeft--;
                System.out.println("Remaining Seconds: " + secondsLeft);
                if (secondsLeft <= 0) {
                    levelTimer.stop();
                    if (onTimeUp != null) {
                        onTimeUp.run();
                        level.dispose();
                        level.switchEnabledButtons();
                        Frames.winLose.updateMessage("lost");
                        Frames.winLose.setVisible(true);
                    }
                }
                updateTimerDisplay();
            }
        });
    }

    public void start(){
        this.secondsLeft = totalSeconds;
        solved = false;
        updateTimerDisplay();
        levelTimer.start();
    }

    public void stop() {
        if (levelTimer != null){
            levelTimer.stop();
        }
    }

    private void updateTimerDisplay() {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;
        timerLabel.setText(String.format("%d:%02d", minutes, seconds));
    }
    
    public void setSolved(boolean solved){
        this.solved = solved;
    }
    
    public void setLevel(Level level){
        this.level = level;
    }
}
