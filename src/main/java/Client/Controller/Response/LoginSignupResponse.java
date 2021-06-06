package Client.Controller.Response;

import Client.View.MyFrame;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.io.PrintWriter;
import java.util.Scanner;

@JsonTypeName("login")
public class LoginSignupResponse implements Response {

    private String type;
    private String res;

    public LoginSignupResponse() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    @Override
    public void process(Scanner inputStream, PrintWriter outputStream, ObjectMapper objectMapper, Object object) {
        if (type.equalsIgnoreCase("signup")) {
            JOptionPane.showMessageDialog(MyFrame.getInstance(), res);
        } else {
            if (res.equals("wrong password")) {
                JOptionPane.showMessageDialog(MyFrame.getInstance(), "wrong password .");
            } else if (res.equals("user not found")) {
                JOptionPane.showMessageDialog(MyFrame.getInstance(), "user not found");
            } else {
                MyFrame.getInstance().createMenuPanel();
            }
        }
    }
}