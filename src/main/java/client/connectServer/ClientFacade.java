package client.connectServer;


import client.observer.ObservableMessages;
import client.observer.ObserverMessage;

import java.util.ArrayList;

/**
 * Created by HNKNTOC on 03.01.2016.
 */
public class ClientFacade implements ObservableMessages, ObserverMessage  {
    private Client client;
    private ArrayList<ObserverMessage> OBSERVER_MESSAGES = new ArrayList<>();

    public ClientFacade() {
        client = new Client(this);

    }


    public void clientStart(){
        client.start();
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
        for(ObserverMessage observerMessage:OBSERVER_MESSAGES){
            observerMessage.updateNewMessage(nameAuthor, content, data);
        }
    }

    @Override
    public void updateNewMessage(String nameAuthor, String content, String data) {
        System.out.println("Client out Messages "+content);
        client.outMessage(content);
    }

}
