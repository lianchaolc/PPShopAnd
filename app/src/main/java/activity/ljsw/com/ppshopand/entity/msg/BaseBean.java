package activity.ljsw.com.ppshopand.entity.msg;

import java.io.Serializable;

/**
 * Created by flashing on 2016/9/14.
 */
public class BaseBean implements Serializable{
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
