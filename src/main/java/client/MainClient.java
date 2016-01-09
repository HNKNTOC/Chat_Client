package client;


import client.connectServer.ClientFacade;
import client.gui.Chat.ChatGUIFacade;
import client.gui.Chat.componentsChat.FactoryMessageDisplay;
import client.gui.Chat.componentsChat.JMessageDisplayTXT;

public class MainClient {

    public static void main(String[] args) {
        ClientFacade clientFacade = new ClientFacade();
        ChatGUIFacade chatGUIFacade = new ChatGUIFacade(clientFacade);

        chatGUIFacade.registerObserver(clientFacade);
        clientFacade.registerObserver(chatGUIFacade);

        chatGUIFacade.startFrameLog();
    }
}
