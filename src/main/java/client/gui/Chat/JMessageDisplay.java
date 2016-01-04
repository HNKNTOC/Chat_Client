package client.gui.Chat;


import javax.swing.*;

/**
 * Отображает множество JMessage.
 */
interface JMessageDisplay {
    void addMessage(JMessage message);
    void removeMessage(JMessage message);
    JPanel getJPanel();
}
