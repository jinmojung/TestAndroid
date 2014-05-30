package kr.codesolutions.recalldetail.vo;


import java.util.List;

/**
 * Created by jinmo on 2014-05-28.
 */
public class RecallDetail extends BaseVo {
    List<RecallDetailContent> content;

    public List<RecallDetailContent> getContent() {
        return content;
    }

    public void setContent(List<RecallDetailContent> content) {
        this.content = content;
    }
}
