package Client.View;

import Client.Controller.RequestHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerConnectPanel extends JPanel implements ActionListener {

    public final JLabel label;
    private final JButton button;
    private final Font font = new Font("Serif", Font.BOLD, 25);
    private final int port;


    public ServerConnectPanel(int port) {
        this.port = port;
        setLayout(null);
        setSize(800, 800);
        setPreferredSize(new Dimension(800, 800));
        label = new JLabel("Click this button to Connect to the Server");
        label.setFont(font);
        label.setBounds(300, 200, 200, 60);
        add(label);

        button = new JButton("Connect to The Server");
        button.setBounds(300, 400, 200, 60);
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RequestHandler.Connect("localhost", port, this);


    }
}
