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

    private Timer timer;
    private final int totalSeconds;
    private int secondsLeft;
    private JLabel timerLabel;
    private Runnable onTimeUp;

    public GameTimer(JLabel timerLabel, int totalSeconds, Runnable onTimeUp) {
        this.totalSeconds = totalSeconds;
        this.timerLabel = timerLabel;
        this.onTimeUp = onTimeUp;
    }

    public void start() {
        this.secondsLeft = totalSeconds;
        updateTimerDisplay();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsLeft--;
                if (secondsLeft <= 0) {
                    timer.stop();
                    if (onTimeUp != null) {
                        onTimeUp.run();
                    }
                }
                updateTimerDisplay();
            }
        });
        timer.start();
    }

    public void stop() {
        if (timer != null) timer.stop();
    }

    private void updateTimerDisplay() {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;
        timerLabel.setText(String.format("%d:%02d", minutes, seconds));
    }
}
