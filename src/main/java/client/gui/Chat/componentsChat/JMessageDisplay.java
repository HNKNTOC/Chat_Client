package client.gui.Chat.componentsChat;




import client.gui.Chat.componentsChat.txt.Message;


import java.awt.*;

/**
 * Отображает добавляемые сообщения.
 */
public interface JMessageDisplay {
    /**
     * Добавляет в дисплей сообщение
     * @param message сообщение которое нужно добавить.
     */
    void addMessage(Message message);

    /**
     * Удаляет все сообщения.
     */
    void removeAllMessage();

    /**
     * Возвращает Component на которой отображены сообщения
     * @return Панель
     */
    Component getComponent();
}
