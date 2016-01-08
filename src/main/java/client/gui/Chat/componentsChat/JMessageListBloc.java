package client.gui.Chat.componentsChat;

import client.gui.Chat.componentsChat.txt.Message;
import client.gui.Chat.componentsChat.txt.MessageStandard;

import javax.swing.*;
import java.awt.*;

/**
 * Отображает JMessage списком
 */
public class JMessageListBloc extends JPanel implements JMessageDisplay {

    public JMessageListBloc() {
        go();
    }

    public void go(){
        setLayout(new GridLayout(0,1));
    }


    @Override
    public void addMessage(Message message) {
        add(new JMessage(message));
        updateUI();
    }

    @Override
    public void removeAllMessage() {
        removeAll();
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }
}
