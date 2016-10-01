package se.java.serializable;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
import java.util.ArrayList;
import java.util.List;

public class ClientObject {

    private List<MyItem> l;

    public ClientObject(List<MyItem> pl) {
        this.l = pl;
    }

    public ClientObject() {
        this.l = new ArrayList<MyItem>();
    }

    public List<MyItem> getL() {
        return this.l;
    }

    public void setL(List<MyItem> l) {
        this.l = l;
    }
}