package client.gui.Chat.componentsChat;




import client.gui.Chat.componentsChat.txt.MessageStandard;

import javax.swing.*;

/**
 * Отображает множество JMessage.
 */
public interface JMessageList {
    void addMessage(MessageStandard message);
    JPanel getJPanel();
}
