package client.connectServer;





import client.ProgramAttributes;
import client.observer.ObservableMessages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 */
 class Client{

    private boolean aBoolean=true;
    private PrintWriter writer;
    private ObservableMessages observable;

    public Client(ObservableMessages observable) {
        this.observable = observable;
    }

    public void start(){
        try {
            System.out.println("Client start....");
            Socket socket = new Socket("127.0.0.1",5050);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread thread = new Thread(new Receiver(reader,this));
            thread.start();

            writer = new PrintWriter(socket.getOutputStream(),true);

            outMessage(ProgramAttributes.nameUser);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void outMessage(String txt){
        writer.println(txt);
    }

    public void newMessage(String nameAuthor, String content, String data){
        System.out.println(nameAuthor+":"+content+", "+data);
        observable.notifyNewMessages(nameAuthor, content, data);
    }
}
