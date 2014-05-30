package kr.codesolutions.recalldetail.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jinmo on 2014-05-28.
 */
public class RequestModelQueryPageable implements Serializable {
    private boolean enable;
    private long pageNumber;
    private long pageSize;
    private List<RequestModelQueryPageableSortOrders> sortOrders;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public List<RequestModelQueryPageableSortOrders> getSortOrders() {
        return sortOrders;
    }

    public void setSortOrders(List<RequestModelQueryPageableSortOrders> sortOrders) {
        this.sortOrders = sortOrders;
    }
}
