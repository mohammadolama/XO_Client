package Client.Controller.Request;

import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@JsonTypeName("login")
public class Login_SignUp_Request implements Request{
    private String username;
    private String password;
    private String type;

    public Login_SignUp_Request(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public Login_SignUp_Request() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void excute(Scanner inputStream, PrintWriter outputStream, ObjectMapper objectMapper, Object object) {
        try {
            String s = objectMapper.writeValueAsString(this);
            outputStream.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
