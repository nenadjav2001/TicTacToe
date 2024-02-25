package Frame;

import javax.swing.JFrame;

/**
 * Die Hauptklasse des Spiels.
 */
public class Main extends JFrame {

    /**
     * Die main-Methode, die beim Start des Programms aufgerufen wird.
     *
     * @param args Die Befehlszeilenargumente (nicht verwendet).
     */
    public static void main(String[] args) {
        // Erstelle eine Instanz des GameFrame und zeige das Spiel an
        GameFrame gameFrame = new GameFrame();
        gameFrame.createFrame();
    }
}
