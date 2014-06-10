package kr.codesolutions.recalldetail.vo;


import java.util.List;

/**
 * Created by jinmo on 2014-05-28.
 */
public class MultiSelectVo  {
    String label;
    String value;
    boolean selected;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return label;
    }
}
