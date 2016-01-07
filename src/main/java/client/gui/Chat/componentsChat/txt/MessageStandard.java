package client.gui.Chat.componentsChat.txt;

/**
 * Сообшение содержит:
 *      nameAuthor
 *      content
 *      data
 */
public class MessageStandard implements Message {
    private String nameAuthor;
    private String content;
    private String data;

    public MessageStandard(String nameAuthor, String content, String data) {
        this.nameAuthor = nameAuthor;
        this.content = content;
        this.data = data;
    }

    @Override
    public String getNameAuthor() {
        return nameAuthor;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MessageStandard{" +
                "nameAuthor='" + nameAuthor + '\'' +
                ", content='" + content + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
