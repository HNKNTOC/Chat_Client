package client.gui.Chat.componentsChat.txt;

/**
 * Стандартная реализация для сообщения с цветом.
 */
public class MessageColorStandard extends MessageStandard implements MessageColor {

    private RuleColoringText colorNameAuthor;

    public MessageColorStandard(Message message,RuleColoringText colorNameAuthor) {
        super(message.getNameAuthor(), message.getContent(), message.getData());
        this.colorNameAuthor = colorNameAuthor;
    }

    @Override
    public RuleColoringText getRuleColoringText() {
        return colorNameAuthor;
    }
}
