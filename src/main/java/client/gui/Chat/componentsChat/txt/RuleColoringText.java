package client.gui.Chat.componentsChat.txt;

import java.awt.*;

/**
 * Правило для раскраски сообщения должно содержать:
 *      Цвет для раскраски Имени автора ColorNameAuthor
 *      Содержания сообщения ColorContent
 *      и цвет даты ColorData.
 */
public interface RuleColoringText {
    Color getColorNameAuthor();
    Color getColorContent();
    Color getColorData();
}
