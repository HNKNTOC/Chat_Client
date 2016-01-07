package client.gui.Chat.componentsChat.txt;

import java.util.HashMap;

/**
 * Отвечает за раскраску сообщения.
 */
public interface InstallerTextColor {
    /**
     * Задаёт цвет отдельным частям Message.
     * Цвет задаётся зависимости от настроек.
     * @param message сообшение которому нужно задать цвет.
     * @return разноцветное сообщение.
     */
    MessageColor getMessageColor(Message message);

    /**
     * Добавляет новое правило для установки цвета Message.
     * @param nameAuthor имя автора которому нужно задать правило.
     * @param ruleColoringText правило по которому будет разукрашиваться сообщение.
     * @return false если правило для имя уже было задано.
     */
    boolean addRegulation(String nameAuthor,RuleColoringText ruleColoringText);

    /**
     * Удоляет правило.
     * @param nameAuthor имя автора правило которому нужно удолить.
     * @return false если правило не удалено.
     */
    boolean removeRegulation(String nameAuthor);

    /**
     * Возвращает HashMap с правилами.
     * Ключ имя автора.
     * @return лист с правилами.
     */
    HashMap<String,RuleColoringText> getListRule();
}
