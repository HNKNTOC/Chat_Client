package client.gui.Chat.componentsChat;




import client.gui.Chat.componentsChat.txt.Message;


import java.awt.*;

/**
 * ���������� ����������� ���������.
 */
public interface JMessageDisplay {
    /**
     * ��������� � ������� ���������
     * @param message ��������� ������� ����� ��������.
     */
    void addMessage(Message message);

    /**
     * ������� ��� ���������.
     */
    void removeAllMessage();

    /**
     * ���������� Component �� ������� ���������� ���������
     * @return ������
     */
    Component getComponent();
}
