package Players;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Die Klasse PlayerO stellt den Spieler O dar.
 */
public class PlayerO {

    // Farbe und Schriftart für den Spieler O
    private Color playerOColor = Color.cyan;
    private Font buttonFont = new Font("Arial", Font.ITALIC, 50);

    // Zeichen für den Spieler O
    private char playerOChar = 'O';

    /**
     * Konstruktor für den Spieler O.
     */
    public PlayerO() {
    }

    /**
     * Methode, die den Zug des Spielers O ausführt.
     *
     * @param e      Das ActionEvent, das den Zug ausgelöst hat.
     * @param button Der Button, auf den der Spieler O geklickt hat.
     */
    public void PlayerOTurn(ActionEvent e, JButton button) {
        // Setze die Schriftart und Farbe des Buttons für den Spieler O
        button.setForeground(playerOColor);
        button.setFont(buttonFont);

        // Überprüfe, ob der Button gedrückt wurde
        if (e.getSource() == button) {
            // Setze den Text des Buttons auf das Zeichen des Spielers O
            button.setText(String.valueOf(playerOChar));
            button.setForeground(playerOColor);
            // Das Label wird in der GamePanel-Klasse aktualisiert, also keine Änderung hier
        }
    }
}
