package client.gui.Chat.componentsChat;

import client.gui.Chat.componentsChat.txt.Message;
import client.gui.Chat.componentsChat.txt.MessageStandard;

import javax.swing.*;
import java.awt.*;

/**
 * Графическое отображение сообщения.
 */
public class JMessage extends JPanel {
    private String nameAuthor;
    private String content;
    private String data;


    public JMessage(String nameAuthor, String content, String data) {
        this.nameAuthor = nameAuthor;
        this.content = content;
        this.data = data;

        go();
    }

    public JMessage(Message massage) {
        this.nameAuthor = massage.getNameAuthor();
        this.content = massage.getContent();
        this.data = massage.getData();

        go();
    }

    public void go(){
        setLayout(new GridBagLayout());

        JLabel labelName = new JLabel(nameAuthor);
        labelName.setBorder(BorderFactory.createEtchedBorder());
        labelName.setForeground(Color.blue);

        JLabel labelContent = new JLabel();
        labelContent.setText(content);
        labelContent.setBorder(BorderFactory.createEtchedBorder());

        JLabel labelData = new JLabel(data);
        labelData.setBorder(BorderFactory.createEtchedBorder());

        JPanel panelA = new JPanel();

        panelA.setLayout(new GridBagLayout());


        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;

        c.weighty= 1;
        c.weightx=1;

        c.gridy = 0;
        c.gridx = 0;

        add(panelA,c);
        panelA.add(labelName, c);

        c.anchor = GridBagConstraints.WEST;

        c.gridy = 1;
        c.gridx = 0;

        panelA.add(labelContent,c);

        c.anchor = GridBagConstraints.NORTHEAST;

        c.weighty= 1;
        c.weightx= 1;

        c.gridy = 0;
        c.gridx = 3;

        add(labelData,c);
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
