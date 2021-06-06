package Client.View;

import Client.Controller.Request.PlayRequest;
import Client.Controller.RequestHandler;
import Client.View.Configs.Config;
import Client.View.Configs.ConfigsLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements ActionListener {

    private final JButton play;
    private final JButton info;
    private final JButton scoreBoard;
    private final JButton replay;
    private final JButton exit;
    private final Config config = ConfigsLoader.getInstance().getConfig();


    public MainMenu() {
        setLayout(null);

        play = new JButton("Play");
        play.setFont(Constants.f2.deriveFont(23.0f));
        play.setBounds(config.getMenuBtnX(), config.getMenuBtnY(), config.getMenuBtnWidth(), config.getMenuBtnHeight());
        play.setFocusable(false);
        play.addActionListener(this);
        add(play);


        info=new JButton("Info");
        info.setFont(Constants.f2.deriveFont(23.0f));
        info.setBounds(config.getMenuBtnX(), config.getMenuBtnY() + 100, config.getMenuBtnWidth(), config.getMenuBtnHeight());
        info.setFocusable(false);
        info.addActionListener(this);
        add(info);

        scoreBoard = new JButton("ScoreBoard");
        scoreBoard.setFont(Constants.f2.deriveFont(23.0f));
        scoreBoard.setBounds(config.getMenuBtnX(), config.getMenuBtnY() + 200, config.getMenuBtnWidth(), config.getMenuBtnHeight());
        scoreBoard.setFocusable(false);
        scoreBoard.addActionListener(this);
        add(scoreBoard);

        replay = new JButton("Replay");
        replay.setFont(Constants.f2.deriveFont(23.0f));
        replay.setBounds(config.getMenuBtnX(), config.getMenuBtnY() + 300, config.getMenuBtnWidth(), config.getMenuBtnHeight());
        replay.setFocusable(false);
        replay.addActionListener(this);
        add(replay);

        exit = new JButton("Exit");
        exit.setFont(Constants.f2.deriveFont(23.0f));
        exit.setBounds(config.getMenuBtnX(), config.getMenuBtnY() + 400, config.getMenuBtnWidth(), config.getMenuBtnHeight());
        exit.setFocusable(false);
        exit.addActionListener(this);
        add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play){
            RequestHandler.getInstance().sendRequest(new PlayRequest());
        }else if (e.getSource() == scoreBoard) {
            MyFrame.getInstance().createScoreBoardPanel();
        } else if (e.getSource() == info) {
            MyFrame.getInstance().createInfoPanel();
        } else if (e.getSource() == replay) {
            MyFrame.getInstance().createReplayPanel();
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}
