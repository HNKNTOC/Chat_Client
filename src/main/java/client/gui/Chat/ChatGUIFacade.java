package client.gui.Chat;



import client.ProgramAttributes;
import client.connectServer.ClientFacade;
import client.gui.Chat.componentsChat.JMessageList;
import client.gui.Chat.componentsChat.JMessageListBloc;
import client.gui.Chat.componentsChat.Message;
import client.observer.ObservableMessages;
import client.observer.ObserverMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by HNKNTOC on 03.01.2016.
 */
public class ChatGUIFacade implements ObservableMessages,ObserverMessage {
    private FrameChat frameChat;
    private FrameLog frameLog;

    private ClientFacade clientFacade;

    private ArrayList<ObserverMessage> OBSERVER_MESSAGES = new ArrayList<>();
    private JMessageList jMessageList = new JMessageListBloc();

    public ChatGUIFacade(ClientFacade clientFacade) {
        this.clientFacade = clientFacade;
    }

    public void setJMessageList(JMessageList jMessageList){
        this.jMessageList=jMessageList;
    }

    public void frameLogStart(){
        frameLog = new FrameLog();
        frameLog.start();
        frameLog.addListenerConnect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProgramAttributes.nameUser = frameLog.getUserName();
                frameLog.stop();
                clientFacade.clientStart();
                frameChatStart();
            }
        });
    }

    public void frameChatStart(){
        frameChat = new FrameChat(jMessageList);
        frameChat.addListenerButtonPrint(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyNewMessages("Hnkntoc Client",frameChat.getTextNewMessage(),"Data Client");
            }
        });
        frameChat.start();
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
        if(frameChat==null){
            return;
        }
        frameChat.getMessageDisplay().addMessage(new Message(nameAuthor,content,data));
    }
}
