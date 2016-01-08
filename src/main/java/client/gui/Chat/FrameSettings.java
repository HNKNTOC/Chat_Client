package client.gui.Chat;

import client.ProgramSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * FrameSettings
 */
public class FrameSettings extends JFrame {
    private JPanel panelSettings;
    private JTextField textFieldIp;
    private JTextField textFieldPort;
    private JComboBox comboBoxDisplay;
    private JButton buttonSave;
    private JButton buttonCancel;


    public FrameSettings() throws HeadlessException {
        super("Settings");

        String[] strings = {"TXT","Bloc"};

        textFieldIp = new JTextField(ProgramSettings.Connect.ip);
        textFieldPort = new JTextField(ProgramSettings.Connect.port+"");
        comboBoxDisplay = new JComboBox<>(strings);
        buttonSave = new JButton("Save");
        buttonCancel = new JButton("Cancel");
    }

    public void addListenerSave(ActionListener listener){
        buttonSave.addActionListener(listener);
    }

    public void addListenerCancel(ActionListener listener){
        buttonCancel.addActionListener(listener);
    }

    public void go(){
        JPanel panelBut = new JPanel();
        panelSettings = new JPanel();

        panelBut.setLayout(new FlowLayout());
        panelSettings.setLayout(new GridBagLayout());

        add(BorderLayout.CENTER, panelSettings);
        add(BorderLayout.SOUTH, panelBut);

        addNewComponent(new JLabel("Ip:"), 0, 0, 1, 1,
                GridBagConstraints.HORIZONTAL,
                GridBagConstraints.NORTHWEST, 1, 1);

        addNewComponent(textFieldIp, 0, 1, 1, 1,
                GridBagConstraints.HORIZONTAL,
                GridBagConstraints.NORTHWEST, 1, 1);

        addNewComponent(new JLabel("Port:"), 1, 0, 1, 1,
                GridBagConstraints.HORIZONTAL,
                GridBagConstraints.NORTHWEST, 1, 1);

        addNewComponent(textFieldPort,1,1,1,1,
                GridBagConstraints.HORIZONTAL,
                GridBagConstraints.NORTHWEST,1,1);

        addNewComponent(new JLabel("Display chat:"), 2, 0, 1, 1,
                GridBagConstraints.HORIZONTAL,
                GridBagConstraints.NORTHWEST, 1, 1);


        addNewComponent(comboBoxDisplay, 2, 1, 1, 1,
                GridBagConstraints.HORIZONTAL,
                GridBagConstraints.NORTHWEST, 1, 1);


        buttonSave.addActionListener(new ActionListenerSave());
        buttonCancel.addActionListener(new ActionListenerCancel());

        panelBut.add(buttonSave);
        panelBut.add(buttonCancel);


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addNewComponent(Component component,
                                int gridy, int gridx,
                                int gridwidth, int gridheight,
                                int fill, int anchor, double weighty, double weightx){
        GridBagConstraints c = new GridBagConstraints();
        c.gridy=gridy; //расположение ячейки
        c.gridx=gridx;

        c.gridwidth=gridwidth; //размеры
        c.gridheight=gridheight;

        c.fill=fill;//тип заполнения

        c.anchor=anchor;// Нахождение контента в ячейке

        c.weighty=weighty;
        c.weightx=weightx;

        panelSettings.add(component, c);

    }

    public void close() {
        setVisible(false);
        dispose();
    }

    class ActionListenerSave implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ProgramSettings.Connect.ip=textFieldIp.getText();
            ProgramSettings.Connect.
                    port=Integer.parseInt(textFieldPort.getText());
        }
    }

    class ActionListenerCancel implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
        }
    }

}
