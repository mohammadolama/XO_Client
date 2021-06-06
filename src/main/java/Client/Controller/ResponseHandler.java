package Client.Controller;

import Client.Controller.Response.Response;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ResponseHandler extends Thread {

    private Scanner input;
    private PrintWriter output;
    private ObjectMapper objectMapper;
    private Object object;

    public ResponseHandler(Scanner input, PrintWriter output, ObjectMapper objectMapper, Object object) {
        this.input = input;
        this.output = output;
        this.objectMapper = objectMapper;
        this.object = object;
    }

    @Override
    public void run() {
        while (true) {
            processRes(input.nextLine());
        }
    }

    public void processRes(String string) {
        new Thread(() -> {
            try {
                Response response = objectMapper.readValue(string, Response.class);
                System.out.println(response.getClass());
                response.process(input, output, objectMapper, object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}