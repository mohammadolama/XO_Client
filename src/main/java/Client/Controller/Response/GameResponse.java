package Client.Controller.Response;

import Client.Model.Message;
import Client.View.MyFrame;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.PrintWriter;
import java.util.Scanner;

@JsonTypeName("game")
public class GameResponse implements Response{
    private Message message;

    public GameResponse(Message message) {
        this.message = message;
    }

    public GameResponse() {
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public void process(Scanner inputStream, PrintWriter outputStream, ObjectMapper objectMapper, Object object) {
        if (MyFrame.getInstance().boardPanel!=null) {
            MyFrame.getInstance().boardPanel.processMessage(message);
        }
    }
}
