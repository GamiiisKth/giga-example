package se.java.serializable.jackson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")@JsonSubTypes({
        @JsonSubTypes.Type(value = MySubItemA.class, name = "MySubItemA"),
        @JsonSubTypes.Type(value = MySubItemB.class, name = "MySubItemB"),
        @JsonSubTypes.Type(value = MySubItemC.class, name = "MySubItemC"),
})
public abstract class MyItem {
    private int id;
    private String name;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
