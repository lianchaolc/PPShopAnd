package activity.ljsw.com.ppshopand.even;

/**
 * Created by flashing on 2016/10/26.
 */
public class MessageEvent {
    private final String message;

    public MessageEvent(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
