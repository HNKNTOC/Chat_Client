package client.gui.Chat;


import javax.swing.*;

/**
 * ���������� ��������� JMessage.
 */
interface JMessageDisplay {
    void addMessage(JMessage message);
    void removeMessage(JMessage message);
    JPanel getJPanel();
}
