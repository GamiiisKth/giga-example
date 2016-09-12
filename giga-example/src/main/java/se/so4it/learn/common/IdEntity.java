package se.so4it.learn.common;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *
 *
 */
public abstract class IdEntity<T>  {

    public abstract T getId();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
