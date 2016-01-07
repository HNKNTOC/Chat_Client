package client.gui.Chat.componentsChat.txt;

import java.util.HashMap;

/**
 * �������� �� ��������� ���������.
 */
public interface InstallerTextColor {
    /**
     * ����� ���� ��������� ������ Message.
     * ���� ������� ����������� �� ��������.
     * @param message ��������� �������� ����� ������ ����.
     * @return ������������ ���������.
     */
    MessageColor getMessageColor(Message message);

    /**
     * ��������� ����� ������� ��� ��������� ����� Message.
     * @param nameAuthor ��� ������ �������� ����� ������ �������.
     * @param ruleColoringText ������� �� �������� ����� ��������������� ���������.
     * @return false ���� ������� ��� ��� ��� ���� ������.
     */
    boolean addRegulation(String nameAuthor,RuleColoringText ruleColoringText);

    /**
     * ������� �������.
     * @param nameAuthor ��� ������ ������� �������� ����� �������.
     * @return false ���� ������� �� �������.
     */
    boolean removeRegulation(String nameAuthor);

    /**
     * ���������� HashMap � ���������.
     * ���� ��� ������.
     * @return ���� � ���������.
     */
    HashMap<String,RuleColoringText> getListRule();
}
