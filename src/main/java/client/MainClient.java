package client;


import client.connectServer.ClientFacade;
import client.gui.Chat.ChatGUIFacade;

public class MainClient {

    public static void main(String[] args) {
        ChatGUIFacade chatGUIFacade = new ChatGUIFacade();
        ClientFacade clientFacade = new ClientFacade();

        chatGUIFacade.registerObserver(clientFacade);
        clientFacade.registerObserver(chatGUIFacade);

        chatGUIFacade.chatStart();
        clientFacade.clientStart();
    }
}
