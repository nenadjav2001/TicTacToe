package Frame;

import javax.swing.*;

/**
 * Die Klasse GameFrame erstellt das Hauptfenster des Spiels.
 */
public class GameFrame extends JFrame {

    // Das Spielpanel
    GamePanel gamePanel;

    /**
     * Konstruktor für das GameFrame.
     */
    public GameFrame() {
        // Erstelle ein neues GamePanel
        gamePanel = new GamePanel();
    }

    /**
     * Methode zum Erstellen und Anzeigen des Frames.
     */
    public void createFrame() {
        // Einstellungen für das Fenster festlegen
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLayout(null);

        // Füge das Spielpanel zum Frame hinzu
        this.add(gamePanel);

        // Zentriere das Fenster auf dem Bildschirm
        this.setLocationRelativeTo(null);

        // Mache das Fenster sichtbar
        this.setVisible(true);
    }
}







