package client.gui.Chat.componentsChat.txt;

import java.util.HashMap;

/**
 * Приводит Message в MessageColor путём добавления правила для раскраски (InstallerTextColor).
 * Какое именно правило будет добавлено зависит от добавляемых правил в лист listRule.
 * Если в листе listRule ключ будет совпадать с именем автора то сообщению будет задано правило привязанное к ключу.
 * Если имя автора не совпадёт не с одним ключом будет задано стандартное правило (RuleColoringTextStandard).
 */
public class InstallerTextColorStandard implements InstallerTextColor {
    HashMap<String, RuleColoringText> listRule = new HashMap<>(); //Лист содержан правила для раскраски сообщения. Ключ имя автора.


    /**
     * Если NameAuthor из Message совпадает с одним из ключей listRule то создаётся messageColor в который
     * задаётся RuleColoringText привязанное к ключу и message.
     * Если NameAuthor из Message не совпадает с одним из ключей listRule то создаётся messageColor в который
     * задаётся RuleColoringTextStandard и message.
     *
     * @param message сообщение которому нужно задать цвет.
     * @return возвращает получившийся messageColor.
     */
    @Override
    public MessageColor getMessageColor(Message message) {
        MessageColor messageColor;
        for (String s : listRule.keySet()) {
            if (message.getNameAuthor().equals(s)) {
                messageColor = new MessageColorStandard(message, listRule.get(s));
                return messageColor;
            }
        }
            messageColor = new MessageColorStandard(message, new RuleColoringTextStandard());
            return messageColor;
    }

    /**
     * Добавляет правило в listRule
     *
     * @param nameAuthor       имя автора которому нужно задать правило.
     * @param ruleColoringText правило по которому будет разукрашиваться сообщение.
     * @return
     */
    @Override
    public boolean addRegulation(String nameAuthor, RuleColoringText ruleColoringText) {
        listRule.put(nameAuthor, ruleColoringText);
        return true;
    }

    @Override
    public boolean removeRegulation(String nameAuthor) {
        listRule.remove(nameAuthor);
        return true;
    }

    @Override
    public HashMap<String, RuleColoringText> getListRule() {
        return listRule;
    }
}
