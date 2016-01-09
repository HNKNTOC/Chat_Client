package client.gui.Chat.componentsChat;

import client.ProgramSettings;

/**
 * Фабрика для получения JMessageDisplay
 */
public class FactoryMessageDisplay {
    public static JMessageDisplay getJMessageDisplay(){

        switch (ProgramSettings.View.numberDisplay){
            case ProgramSettings.View.DisplayBloc: return new JMessageDisplayBloc();
            case ProgramSettings.View.DisplayTXT: return new JMessageDisplayTXT();
        }
        return new JMessageDisplayTXT();
    }
}
