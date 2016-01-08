package client;


import client.connectServer.ClientFacade;
import client.gui.Chat.ChatGUIFacade;
import client.gui.Chat.componentsChat.JMessageListTXT;

public class MainClient {

    public static void main(String[] args) {
        ClientFacade clientFacade = new ClientFacade();
        ChatGUIFacade chatGUIFacade = new ChatGUIFacade(clientFacade);

        chatGUIFacade.registerObserver(clientFacade);
        clientFacade.registerObserver(chatGUIFacade);

        chatGUIFacade.setJMessageList(new JMessageListTXT());

        chatGUIFacade.startFrameLog();
    }
}
