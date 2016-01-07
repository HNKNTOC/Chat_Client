package client.gui.Chat.componentsChat;

import client.ProgramAttributes;
import client.gui.Chat.componentsChat.txt.*;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

/**
 * ���������� JMessage ���� ���
 */
public class JMessageListTXT extends JPanel implements JMessageList {

    private String txt ="";
    private JTextPane textPane;
    private Document document;
    private static AttributeSet attributeSet;

    public JMessageListTXT() {
        go();
    }

    public void  go(){
        textPane = new JTextPane();
        textPane.setEditable(false);

        document = textPane.getDocument();





        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(textPane);
    }


    @Override
    public void addMessage(MessageStandard message) {
        InstallerTextColor installer = new InstallerTextColorStandard();
        installer.addRegulation(ProgramAttributes.nameUser, new RuleColoringText() {
            @Override
            public Color getColorNameAuthor() {
                return Color.MAGENTA;
            }

            @Override
            public Color getColorContent() {
                return Color.black;
            }

            @Override
            public Color getColorData() {
                return Color.black;
            }
        });

        installer.addRegulation("Server", new RuleColoringText() {
            @Override
            public Color getColorNameAuthor() {
                return Color.red;
            }

            @Override
            public Color getColorContent() {
                return Color.red;
            }

            @Override
            public Color getColorData() {
                return Color.red;
            }
        });

        MessageColor messageColor = installer.getMessageColor(message);

        insert(message, messageColor.getRuleColoringText());

    }

    public void insert(Message message,RuleColoringText rule){
        insertDocument(getAttributeColor(rule.getColorNameAuthor()),message.getNameAuthor()+":");
        insertDocument(getAttributeColor(rule.getColorContent()),message.getContent()+"\n");

    }

    public AttributeSet getAttributeColor(Color color){
        return attributeSet = StyleContext.getDefaultStyleContext().addAttribute(SimpleAttributeSet.EMPTY,
                StyleConstants.Foreground, color);
    }

    public void insertDocument(AttributeSet set,String txt){
        try {
            document.insertString(document.getLength(),txt,set);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JMessageListTXT listTXT = new JMessageListTXT();

        listTXT.addMessage(new MessageStandard("HNKNTOC","qwedqwed qwd qw d qw dqw   HGUK dus igdsj ds ds adf ",""));
        listTXT.addMessage(new MessageStandard("Server","Hsadfsadfsadfdfdf",""));
        listTXT.addMessage(new MessageStandard("HNKNTOC","Lol",""));

        jFrame.add(BorderLayout.CENTER,listTXT);

        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setSize(200, 200);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }


}
