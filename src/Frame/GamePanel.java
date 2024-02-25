package Frame;

import Players.PlayerO;
import Players.PlayerX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * Die Klasse GamePanel stellt das Spielfeld für Tic-Tac-Toe dar.
 */
public class GamePanel extends JPanel {

    // Klassenvariablen
    private final int panelWidth = 600;
    private final int panelHeight = 600;

    // Buttons für das Spiel
    private JButton[] buttonsGame;

    // Labels
    private JLabel labelTurn;

    // Player Objekte
    private PlayerX playerX;
    private PlayerO playerO;

    // Zustand des aktuellen Spielers
    private boolean isPlayerXTurn;

    /**
     * Konstruktor für das GamePanel.
     */
    public GamePanel() {
        this.setBounds(0, 0, panelWidth, panelHeight);
        this.setBackground(Color.black);
        this.setOpaque(true);
        this.setLayout(new GridLayout(4, 4, 15, 15)); // Verringerte Abstände

        // Objekte werden erstellt
        buttonsGame = new JButton[9];

        // Methoden für das Panel
        addingGameButtons();

        // Erstellen der Labels
        labelTurn = new JLabel();
        labelTurn.setFont(new Font("Arial", Font.ITALIC, 25));

        // Erstellen der Player Objekte
        playerX = new PlayerX();
        playerO = new PlayerO();

        // Spiel starten
        startGame();
    }

    /**
     * Methode zum Hinzufügen der Spielbuttons zum Panel.
     */
    public void addingGameButtons() {
        for (int i = 0; i < buttonsGame.length; i++) {
            buttonsGame[i] = new JButton();
            buttonsGame[i].setSize(100, 100);
            buttonsGame[i].setBackground(Color.black);
            buttonsGame[i].setBorder(BorderFactory.createLineBorder(Color.yellow, 3, true));
            buttonsGame[i].setFocusable(false);
            buttonListener(buttonsGame[i]);

            this.add(buttonsGame[i]);
        }
    }

    /**
     * Methode zum Starten des Spiels und Festlegen des Startspielers.
     */
    public void startGame() {
        // Startspieler zufällig festlegen
        Random random = new Random();
        isPlayerXTurn = random.nextBoolean();

        // Spieler X beginnt
        if (isPlayerXTurn) {
            labelTurn.setForeground(Color.red);
            labelTurn.setText("Spieler X ");
        } else {
            labelTurn.setForeground(Color.cyan);
            labelTurn.setText("Spieler O ");
        }
        this.add(labelTurn);
    }

    /**
     * Methode zum Hinzufügen des ActionListener für einen Button.
     *
     * @param button Der Button, dem der ActionListener hinzugefügt werden soll.
     */
    public void buttonListener(JButton button) {
        button.addActionListener(e -> {
            // Zug des aktuellen Spielers ausführen
            if (isPlayerXTurn) {
                playerX.PlayerXTurn(e, button);
            } else {
                playerO.PlayerOTurn(e, button);
            }

            // Den Zustand des aktuellen Spielers aktualisieren
            isPlayerXTurn = !isPlayerXTurn;

            // Aktualisiere das Label basierend auf dem neuen Spieler
            updateTurnLabel();

            // Überprüfe, ob ein Spieler gewonnen hat
            if (checkWin()) {
                // Gewinnaktionen ausführen
                JOptionPane.showMessageDialog(this, (isPlayerXTurn ? "Spieler O" : "Spieler X") + " hat gewonnen!");
                resetGame();
            }
        });
    }

    /**
     * Methode zum Aktualisieren des Labels basierend auf dem aktuellen Spieler.
     */
    private void updateTurnLabel() {
        if (isPlayerXTurn) {
            labelTurn.setForeground(Color.red);
            labelTurn.setText("Spieler X ");
        } else {
            labelTurn.setForeground(Color.cyan);
            labelTurn.setText("Spieler O ");
        }
    }

    /**
     * Methode zum Überprüfen, ob ein Spieler gewonnen hat.
     *
     * @return true, wenn ein Spieler gewonnen hat, ansonsten false.
     */
    public boolean checkWin() {
        // Gewinnkombinationen
        int[][] winCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Horizontale Reihen
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Vertikale Reihen
                {0, 4, 8}, {2, 4, 6} // Diagonalen
        };

        for (int[] combination : winCombinations) {
            int a = combination[0];
            int b = combination[1];
            int c = combination[2];

            if (buttonsGame[a].getText().equals(buttonsGame[b].getText()) &&
                    buttonsGame[b].getText().equals(buttonsGame[c].getText()) &&
                    !buttonsGame[a].getText().equals("")) {
                return true; // Gewonnen
            }
        }

        return false; // Kein Gewinner
    }

    /**
     * Methode zum Zurücksetzen des Spiels nach einem Gewinn.
     */
    public void resetGame() {
        for (JButton button : buttonsGame) {
            button.setText(""); // Setze den Text der Buttons zurück
        }
        startGame(); // Starte das Spiel erneut
    }
}
