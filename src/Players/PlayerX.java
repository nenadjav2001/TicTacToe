package Players;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Die Klasse PlayerX stellt den Spieler X dar.
 */
public class PlayerX {

    // Farbe und Schriftart für den Spieler X
    private Color playerXColor = Color.red;
    private Font buttonFont = new Font("Arial", Font.ITALIC, 50);

    // Zeichen für den Spieler X
    private char playerXChar = 'X';

    /**
     * Konstruktor für den Spieler X.
     */
    public PlayerX() {
    }

    /**
     * Methode, die den Zug des Spielers X ausführt.
     *
     * @param e      Das ActionEvent, das den Zug ausgelöst hat.
     * @param button Der Button, auf den der Spieler X geklickt hat.
     */
    public void PlayerXTurn(ActionEvent e, JButton button) {
        // Setze die Schriftart und Farbe des Buttons für den Spieler X
        button.setForeground(playerXColor);
        button.setFont(buttonFont);

        // Überprüfe, ob der Button gedrückt wurde
        if (e.getSource() == button) {
            // Setze den Text des Buttons auf das Zeichen des Spielers X
            button.setText(String.valueOf(playerXChar));
            button.setForeground(playerXColor);
            // Das Label wird in der GamePanel-Klasse aktualisiert, also keine Änderung hier
        }
    }
}








