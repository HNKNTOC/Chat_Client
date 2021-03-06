package client.connectServer;



import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HNKNTOC on 26.12.2015.
 */
class Receiver implements Runnable {
    private BufferedReader in;
    private Client listener;

    public Receiver(BufferedReader in,Client listener) {
        this.in = in;
        this.listener = listener;
    }

    @Override
    public void run() {
        try {
            String name;
            String massage;
            String date;
            while (true){

                    while ((name=in.readLine())!=null){
                        massage=in.readLine();
                        date=in.readLine();
                        listener.newMessage(name,massage,date);
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
            listener.newMessage("Client","Server disconnect",new SimpleDateFormat("h:mm").format(new Date()));
        }
    }

    public void close(){
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
