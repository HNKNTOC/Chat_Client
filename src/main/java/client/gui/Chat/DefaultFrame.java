package client.gui.Chat;

import javax.swing.*;
import java.awt.*;

/**
 * Стандартная настройка JFrama и добавление методов start,stop.
 */
 abstract class DefaultFrame extends JFrame {

    public DefaultFrame() {
       super("DefaultFrame");
    }

    public DefaultFrame(String title) throws HeadlessException {
        super(title);
    }

    public void setDefaultSettings(){
        setSize(200,200);
        setLocationRelativeTo(null);
        pack();
    }

    public void start(){
        setVisible(true);
    }
}
