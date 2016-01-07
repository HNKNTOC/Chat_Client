package client.gui.Chat.componentsChat;

import client.gui.Chat.componentsChat.txt.MessageStandard;

import javax.swing.*;
import java.awt.*;

/**
 * Отображает JMessage списком
 */
public class JMessageListBloc extends JPanel implements JMessageList {

    public JMessageListBloc() {
        go();
    }

    public void go(){
        setLayout(new GridLayout(0,1));
    }


    @Override
    public void addMessage(MessageStandard message) {
        add(new JMessage(message));
        updateUI();
    }


    @Override
    public JPanel getJPanel() {
        return this;
    }
}
