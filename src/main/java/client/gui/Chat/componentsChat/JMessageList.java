package client.gui.Chat.componentsChat;




import javax.swing.*;

/**
 * Отображает множество JMessage.
 */
public interface JMessageList {
    void addMessage(Message message);
    JPanel getJPanel();
}
