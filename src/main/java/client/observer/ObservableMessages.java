package client.observer;


/**
 * Created by HNKNTOC on 03.01.2016.
 */
public interface ObservableMessages {
    void registerObserver(ObserverMessage o);
    void removeObserver(ObserverMessage o);
    void notifyNewMessages(String nameAuthor, String content, String data);
}
