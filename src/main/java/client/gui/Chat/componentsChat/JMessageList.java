package client.gui.Chat.componentsChat;




import client.gui.Chat.componentsChat.txt.MessageStandard;

import javax.swing.*;

/**
 * ���������� ��������� JMessage.
 */
public interface JMessageList {
    void addMessage(MessageStandard message);
    JPanel getJPanel();
}
