package client;


import client.connectServer.ClientFacade;
import client.gui.Chat.ChatGUIFacade;
import client.gui.Chat.componentsChat.JMessageListTXT;

public class MainClient {

    public static void main(String[] args) {
        ChatGUIFacade chatGUIFacade = new ChatGUIFacade();
        ClientFacade clientFacade = new ClientFacade();

        ProgramAttributes.nameUser="Ctac";

        chatGUIFacade.registerObserver(clientFacade);
        clientFacade.registerObserver(chatGUIFacade);

        chatGUIFacade.setJMessageList(new JMessageListTXT());

        chatGUIFacade.chatStart();
        clientFacade.clientStart();
    }
}
