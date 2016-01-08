package client.connectServer;


import client.gui.Chat.componentsChat.txt.Message;
import client.gui.Chat.componentsChat.txt.MessageStandard;
import client.observer.ObservableMessages;
import client.observer.ObserverMessage;

import java.util.ArrayList;

/**
 * Created by HNKNTOC on 03.01.2016.
 */
public class ClientFacade implements ObservableMessages, ObserverMessage  {
    private Client client;
    private ArrayList<ObserverMessage> OBSERVER_MESSAGES = new ArrayList<>();
    private ArrayList<Message> messages;

    public ClientFacade() {
        client = new Client(this);
        messages = new ArrayList<>();

    }


    public boolean clientStart(){
        return client.connect();
    }

    @Override
    public void registerObserver(ObserverMessage o) {
        OBSERVER_MESSAGES.add(o);
    }

    @Override
    public void removeObserver(ObserverMessage o) {
        OBSERVER_MESSAGES.remove(o);
    }

    @Override
    public void notifyNewMessages(String nameAuthor, String content, String data) {
        messages.add(new MessageStandard(nameAuthor,content,data));
        for(ObserverMessage observerMessage:OBSERVER_MESSAGES){
            observerMessage.updateNewMessage(nameAuthor, content, data);
        }
    }

    @Override
    public void updateNewMessage(String nameAuthor, String content, String data) {
        System.out.println("Client out Messages "+content);
        client.outMessage(content);
    }

    public ArrayList<Message> getAllMessages() {
        return messages;
    }
}
