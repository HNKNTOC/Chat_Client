package client.connectServer;



import java.io.BufferedReader;
import java.io.IOException;

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
