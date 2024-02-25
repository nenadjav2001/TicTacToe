package Frame;


import javax.swing.*;

public class GameFrame extends JFrame {

    GamePanel gamePanel;

public GameFrame(){

    gamePanel = new GamePanel();
}

public void createFrame(){

    this.setTitle("TicTacToe");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(600 , 600);
    this.setResizable(false);
    this.setLayout(null);
    this.add(gamePanel);


    this.setLocationRelativeTo(null);
    this.setVisible(true);


}






}