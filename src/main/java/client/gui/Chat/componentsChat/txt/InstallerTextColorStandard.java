package client.gui.Chat.componentsChat.txt;

import java.util.HashMap;

/**
 * �������� Message � MessageColor ���� ���������� ������� ��� ��������� (InstallerTextColor).
 * ����� ������ ������� ����� ��������� ������� �� ����������� ������ � ���� listRule.
 * ���� � ����� listRule ���� ����� ��������� � ������ ������ �� ��������� ����� ������ ������� ����������� � �����.
 * ���� ��� ������ �� ������� �� � ����� ������ ����� ������ ����������� ������� (RuleColoringTextStandard).
 */
public class InstallerTextColorStandard implements InstallerTextColor {
    HashMap<String, RuleColoringText> listRule = new HashMap<>(); //���� �������� ������� ��� ��������� ���������. ���� ��� ������.


    /**
     * ���� NameAuthor �� Message ��������� � ����� �� ������ listRule �� �������� messageColor � �������
     * ������� RuleColoringText ����������� � ����� � message.
     * ���� NameAuthor �� Message �� ��������� � ����� �� ������ listRule �� �������� messageColor � �������
     * ������� RuleColoringTextStandard � message.
     *
     * @param message ��������� �������� ����� ������ ����.
     * @return ���������� ������������ messageColor.
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
     * ��������� ������� � listRule
     *
     * @param nameAuthor       ��� ������ �������� ����� ������ �������.
     * @param ruleColoringText ������� �� �������� ����� ��������������� ���������.
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
