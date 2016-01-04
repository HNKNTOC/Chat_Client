package client.gui.Chat.componentsChat;

/**
 * Сообшение содержит:
 *      nameAuthor
 *      content
 *      data
 */
public class Message {
    private String nameAuthor;
    private String content;
    private String data;

    public Message(String nameAuthor, String content, String data) {
        this.nameAuthor = nameAuthor;
        this.content = content;
        this.data = data;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public String getContent() {
        return content;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "nameAuthor='" + nameAuthor + '\'' +
                ", content='" + content + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
