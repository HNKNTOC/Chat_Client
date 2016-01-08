package client.connectServer;





import client.ProgramAttributes;
import client.ProgramSettings;
import client.observer.ObservableMessages;

import javax.swing.*;
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

    public boolean connect(){
        try {
            System.out.println("Client connect....");
            Socket socket = new Socket(ProgramSettings.Connect.ip,ProgramSettings.Connect.port);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread thread = new Thread(new Receiver(reader,this));
            thread.start();

            writer = new PrintWriter(socket.getOutputStream(),true);

            outMessage(ProgramAttributes.nameUser);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void outMessage(String txt){
        writer.println(txt);
    }

    public void newMessage(String nameAuthor, String content, String data){
        System.out.println(nameAuthor+":"+content+", "+data);
        observable.notifyNewMessages(nameAuthor, content, data);
    }
}
