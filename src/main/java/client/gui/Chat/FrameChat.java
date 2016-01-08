package client.gui.Chat;



import client.gui.Chat.componentsChat.JMessageDisplay;
import client.gui.Chat.componentsChat.txt.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Чат для отображения сообщений и написания новых сообщений.
 * Содержит две панели panelCenter и panelNewMessage
 *  В panelCenter находится messageDisplay;
 *  В panelNewMessage textFieldMessage и buttonPrint,
 */
public class FrameChat extends JFrame{

    private JMessageDisplay messageDisplay;
    private JTextField textFieldMessage = new JTextField();
    private JButton buttonPrint = new JButton("Go!");

    public FrameChat(JMessageDisplay messageDisplaying){
        super("Chat");
        this.messageDisplay = messageDisplaying;
        addWindowListener(new ChatWindowsListner());
        textFieldMessage.addKeyListener(new KeyListenerChat());
    }

    public JMessageDisplay getMessageDisplay() {
        return messageDisplay;
    }

    public void addListenerButtonPrint(ActionListener listener){
        buttonPrint.addActionListener(listener);
    }

    public String getTextNewMessage(){
        return textFieldMessage.getText();
    }

    public JTextField getTextFieldMessage() {
        return textFieldMessage;
    }

    public void start(){
        go();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(300,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void go(){
        JPanel panelCenter = new JPanel();
        JPanel panelNewMessage = new JPanel();

        panelCenter.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        add(BorderLayout.CENTER, panelCenter);
        add(BorderLayout.SOUTH,panelNewMessage);



        panelNewMessage.setLayout(new BoxLayout(panelNewMessage, BoxLayout.X_AXIS));
        panelNewMessage.add(textFieldMessage);
        panelNewMessage.add(buttonPrint);


        JScrollPane scrollPaneList = new JScrollPane(messageDisplay.getJPanel());
        //add messageDisplay
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1;
        c.weighty = 1;

        c.gridwidth = 0;
        c.gridheight = 0;

        c.gridy = 0;
        c.gridx = 0;
        panelCenter.add(scrollPaneList, c);

    }

    public void updateMessageDisplay(ArrayList<Message> messages){
        messageDisplay.removeAllMessage();
        for(Message message:messages){
            messageDisplay.addMessage(message);
        }
    }


    class ChatWindowsListner implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

    class KeyListenerChat implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                buttonPrint.doClick();
            }
        }
    }
}
