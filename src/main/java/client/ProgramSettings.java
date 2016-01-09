package client;

/**
 * Здесь хранятся настройки программы
 */
public interface ProgramSettings {
     class Connect{
         public static String ip="127.0.0.1";
         public static int port=5050;
    }

    class View{
        public static final int DisplayTXT = 0;
        public static final int DisplayBloc = 1;


        public static int numberDisplay=0;//Номер дисплея на котором будут отображаться сообщения
    }
}
