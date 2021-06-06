package Client.Controller;

import Client.Controller.Request.Request;
import Client.View.MyFrame;
import Client.View.ServerConnectPanel;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class RequestHandler {
    //    private static Admin admin = Admin.getInstance();
    private static RequestHandler requestHandler;
    private Socket socket;
    private Scanner scanner;
    private PrintWriter printWriter;
    private ObjectMapper objectMapper;
    private ResponseHandler responseHandler;
    private final Object object = new Object();

    private RequestHandler(Socket socket) {
        try {
            this.socket = socket;
            this.scanner = new Scanner(socket.getInputStream());
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
            objectMapper = new ObjectMapper();
            responseHandler = new ResponseHandler(scanner, printWriter, objectMapper, object);
            responseHandler.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createInstance(Socket socket) {
        requestHandler = new RequestHandler(socket);
    }

    public static RequestHandler getInstance() {
        return requestHandler;
    }


    public synchronized void sendRequest(Request request) {
        if (socket.isConnected()) {
            request.excute(scanner, printWriter, objectMapper, object);
        } else {

        }
    }

    public static void Connect(String ip, int port, ServerConnectPanel panel) {
        try {
            Socket socket = new Socket(ip, port);
            createInstance(socket);
            MyFrame.getInstance().createLoginPanel();
        } catch (IOException e) {
            panel.label.setText("Connection Error");
        }
    }

}