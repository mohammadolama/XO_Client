package Client.View;

import Client.Controller.Request.InfoRequest;
import Client.Controller.Request.ReplayRequest;
import Client.Controller.Request.ScoreBoardRequest;
import Client.Controller.RequestHandler;
import Client.Model.Player;
import Client.Model.PlayerModel;
import Client.View.Configs.Config;
import Client.View.Configs.ConfigsLoader;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MyFrame extends JFrame {

    private static MyFrame myFrame;
    private final Config config = ConfigsLoader.getInstance().getConfig();
    public ScorePanel scorePanel;
    public BoardPanel boardPanel;

    public MyFrame(int port) {
        Random random = new Random();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(config.getFrameWidth(), config.getFrameHeight());
        ServerConnectPanel panel1 = new ServerConnectPanel(port);
        setContentPane(panel1);
        setVisible(true);
    }

    public static MyFrame getInstance(int port) {
        if (myFrame == null) {
            myFrame = new MyFrame(port);
        }
        return myFrame;
    }

    public static MyFrame getInstance() {
        return myFrame;
    }


    public void createLoginPanel() {
        LoginPanel loginPanel = new LoginPanel();
        setContentPane(loginPanel);
        revalidate();
        repaint();
    }

    public void createMenuPanel() {
        MainMenu mainMenu = new MainMenu();
        setContentPane(mainMenu);
        revalidate();
        repaint();

    }

    public void createInfoPanel() {
        RequestHandler.getInstance().sendRequest(new InfoRequest());
    }

    public void createInfoPanel(Player player) {
        InfoPanel infoPanel = new InfoPanel( player);
        setContentPane(infoPanel);
        revalidate();
        repaint();
    }

    public void createScoreBoardPanel() {
        RequestHandler.getInstance().sendRequest(new ScoreBoardRequest(2));
    }
    public void createScoreBoardPanel(ArrayList<PlayerModel> playerModels) {
        ScorePanel scorePanel = new ScorePanel(playerModels);
        this.scorePanel=scorePanel;
        setContentPane(scorePanel);
        revalidate();
        repaint();
    }

    public void createReplayPanel() {
        RequestHandler.getInstance().sendRequest(new ReplayRequest());
    }

    public void createReplayPanel(ArrayList<String[][]> replays ) {
        if (replays==null || replays.size()==0){
            JOptionPane.showMessageDialog(this , "No replays available.");
        }else {
            for (String[][] replay : replays) {
                Arrays.toString(replay);
            }
            ReplayPanel replayPanel = new ReplayPanel(replays);
            setContentPane(replayPanel);
            revalidate();
            repaint();
        }
    }

    public BoardPanel createGamePanel(String friendly, String opponent, String opponentName) {
        BoardPanel boardPanel = new BoardPanel( friendly, opponent, opponentName);
        this.boardPanel = boardPanel;
        setContentPane(boardPanel);
        revalidate();
        repaint();
        return boardPanel;
    }

}