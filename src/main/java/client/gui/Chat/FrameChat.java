package client.gui.Chat;



import client.gui.Chat.componentsChat.JMessageList;
import client.gui.Chat.componentsChat.JMessageListBloc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Чат для отображения сообщений и написания новых сообщений.
 * Содержит две панели panelCenter и panelNewMessage
 *  В panelCenter находится messageDisplay;
 *  В panelNewMessage textFieldNewMessage и buttonPrint,
 */
class FrameChat extends JFrame{

    private JMessageList messageDisplay;
    private JTextField textFieldNewMessage = new JTextField();
    private JButton buttonPrint = new JButton("Go!");

    public FrameChat(){
        super("Chat");
        this.messageDisplay = new JMessageListBloc();
    }

    public FrameChat(JMessageList messageDisplaying){
        super("Chat");
        this.messageDisplay = messageDisplaying;
    }

    public JMessageList getMessageDisplay() {
        return messageDisplay;
    }

    public void addListenerButtonPrint(ActionListener listener){
        buttonPrint.addActionListener(listener);
    }

    public String getTextNewMessage(){
        return textFieldNewMessage.getText();
    }

    public void start(){
        go();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        panelNewMessage.add(textFieldNewMessage);
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

}
