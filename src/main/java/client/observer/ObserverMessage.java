package client.observer;

/**
 * Created by HNKNTOC on 03.01.2016.
 */
public interface ObserverMessage {
    void updateNewMessage(String nameAuthor, String content, String data);
}
