package client.gui.Chat.componentsChat;

import javax.swing.*;
import java.awt.*;

/**
 * Отображает JMessage типа чат
 */
public class JMessageListTXT extends JPanel implements JMessageList {

    private String txt ="";
    private JTextPane textPane;

    public JMessageListTXT() {
        go();
    }

    public void  go(){
        textPane = new JTextPane();

        textPane.setEditable(false);

       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(textPane);
    }

    @Override
    public void addMessage(Message message) {
        txt = txt+message.getNameAuthor()+":"+message.getContent()+"\n";
        textPane.setText(txt);
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JMessageListTXT listTXT = new JMessageListTXT();

        listTXT.addMessage(new Message("Hnkntoc","qwedqwed qwd qw d qw dqw   HGUK dus igdsj ds ds adf ",""));
        listTXT.addMessage(new Message("Vasa","Hsadfsadfsadfdfdf",""));
        listTXT.addMessage(new Message("Hnkntoc","Lol",""));

        jFrame.add(BorderLayout.CENTER,listTXT);

        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setSize(200, 200);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }
}
