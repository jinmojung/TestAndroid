package kr.codesolutions.recalldetail.vo;

import java.io.Serializable;

/**
 * Created by jinmo on 2014-05-28.
 */
public class RequestModelQueryPageableSortOrders implements Serializable {
    private String property;
    private long direction;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public long getDirection() {
        return direction;
    }

    public void setDirection(long direction) {
        this.direction = direction;
    }
}
