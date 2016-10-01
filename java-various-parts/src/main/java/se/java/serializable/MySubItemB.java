package se.java.serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class MySubItemB extends MyItem {

    private int itemBProperty1;
    private String itemBProperty2;

    public int getItemBProperty1() {
        return this.itemBProperty1;
    }

    public void setItemBProperty1(int itemBProperty1) {
        this.itemBProperty1 = itemBProperty1;
    }

    public String getItemBProperty2() {
        return this.itemBProperty2;
    }

    public void setItemBProperty2(String itemBProperty2) {
        this.itemBProperty2 = itemBProperty2;
    }
    @JsonCreator
    public MySubItemB(@JsonProperty("id")int id, @JsonProperty("name")String name, @JsonProperty("itemAProperty1")int p1, @JsonProperty("itemAProperty2")String p2) {
        super(id, name);
        this.itemBProperty1 = p1;
        this.itemBProperty2 = p2;
    }
}