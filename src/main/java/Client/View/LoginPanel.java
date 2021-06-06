package Client.View;

import Client.Controller.Request.Login_SignUp_Request;
import Client.Controller.RequestHandler;
import Client.View.Configs.Config;
import Client.View.Configs.ConfigsLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginPanel extends JPanel implements ActionListener, MouseListener {


    private JButton source;

    private final JButton createAccount;
    private final JButton enter;
    private final JTextField userField;
    private final JTextField passField;
    private Config config;

    private void initConfig() {
        config = ConfigsLoader.getInstance().getConfig();
    }


    public LoginPanel() {
        initConfig();
        setLayout(null);
        createAccount = new JButton("Create new Account");
        createAccount.setFont(Constants.f2.deriveFont(20.0f));

        enter = new JButton("Enter");
        enter.setFont(Constants.f2.deriveFont(20.0f));

        JLabel userLabel = new JLabel("Username : ");
        userLabel.setFont(Constants.f2);

        JLabel passLabel = new JLabel("Password  : ");
        passLabel.setFont(Constants.f2);

        userField = new JTextField(10);
        passField = new JTextField(10);


        createAccount.setFont(Constants.f2.deriveFont(20.f));
        createAccount.setFocusable(false);
        createAccount.addActionListener(this);
        createAccount.addMouseListener(this);

        enter.setFont(Constants.f2.deriveFont(20.f));
        enter.setFocusable(false);
        enter.addActionListener(this);
        enter.addMouseListener(this);


        userField.setBounds(config.getUserLabelX() + 150, config.getUserLabelY(), config.getUserLabelWidth(), config.getUserLabelHeight());
        passField.setBounds(config.getUserLabelX() + 150, config.getUserLabelY() + 50, config.getUserLabelWidth(), config.getUserLabelHeight());
        userLabel.setBounds(config.getUserLabelX(), config.getUserLabelY(), config.getUserLabelWidth(), config.getUserLabelHeight());
        passLabel.setBounds(config.getUserLabelX(), config.getUserLabelY() + 50, config.getUserLabelWidth(), config.getUserLabelHeight());
        enter.setBounds(300, 350, 250, 30);
        createAccount.setBounds(300, 400, 250, 30);


        add(userField);
        add(passField);
        add(userLabel);
        add(passLabel);
        add(enter);
        add(createAccount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enter) {
            if (userField.getText().equals("") || passField.getText().equals("")) {
                JOptionPane.showMessageDialog(this , "fill the fields.");
                return;
            }
            RequestHandler.getInstance().sendRequest(new Login_SignUp_Request(userField.getText() , passField.getText() , "login"));
        } else if (e.getSource() == createAccount) {
            if (userField.getText().equals("") || passField.getText().equals("")) {
                return;
            }
            RequestHandler.getInstance().sendRequest(new Login_SignUp_Request(userField.getText() , passField.getText() , "signup"));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        source = (JButton) e.getSource();
        source.setBackground(new Color(240, 255, 97));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        source.setBackground(Color.WHITE);
    }

}
