package client.gui.Chat;



import client.ProgramAttributes;
import client.connectServer.ClientFacade;
import client.gui.Chat.componentsChat.JMessageDisplay;
import client.gui.Chat.componentsChat.JMessageListBloc;
import client.gui.Chat.componentsChat.txt.MessageStandard;
import client.observer.ObservableMessages;
import client.observer.ObserverMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Фасад для управления GUI
 */
public class ChatGUIFacade implements ObservableMessages,ObserverMessage {
    private FrameChat frameChat;
    private FrameLog frameLog;
    private FrameSettings frameSettings;


    private ArrayList<ObserverMessage> OBSERVER_MESSAGES = new ArrayList<>();
    private JMessageDisplay jMessageList = new JMessageListBloc();
    private ClientFacade clientFacade;

    public ChatGUIFacade(ClientFacade clientFacade) {
        this.clientFacade = clientFacade;
    }

    public void setJMessageList(JMessageDisplay jMessageList){
        this.jMessageList=jMessageList;
    }

    public void startFrameLog(){
        frameLog = new FrameLog();
        frameLog.start();
        frameLog.addListenerConnect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProgramAttributes.nameUser = frameLog.getUserName();
                frameLog.stop();
                startFrameSettings();
            }
        });
    }

    public void startFrameChat(){
        frameChat = new FrameChat(jMessageList);
        frameChat.addListenerButtonPrint(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyNewMessages("Hnkntoc Client", frameChat.getTextNewMessage(), "Data Client");
                frameChat.getTextFieldMessage().setText("");
            }
        });

        frameChat.updateMessageDisplay(clientFacade.getAllMessages());

        frameChat.start();
    }

    public void startFrameSettings(){
        frameSettings = new FrameSettings();

        frameSettings.addListenerSave(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clientFacade.clientStart()){
                    frameSettings.close();
                    startFrameChat();
                }else {
                    JOptionPane.showMessageDialog(null, "Server is not available", "Error connect", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frameSettings.addListenerCancel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frameSettings.go();
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
        frameChat.getMessageDisplay().addMessage(new MessageStandard(nameAuthor,content,data));
    }
}
