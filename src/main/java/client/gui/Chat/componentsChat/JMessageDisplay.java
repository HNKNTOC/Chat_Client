package client.gui.Chat.componentsChat;




import client.gui.Chat.componentsChat.txt.Message;

import javax.swing.*;

/**
 * ���������� ��������� JMessage.
 */
public interface JMessageDisplay {
    void addMessage(Message message);
    void removeAllMessage();
    JPanel getJPanel();
}
