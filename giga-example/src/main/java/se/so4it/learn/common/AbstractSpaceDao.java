package se.so4it.learn.common;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public  abstract class AbstractSpaceDao<T extends IdEntity, ID> implements GenericDao<T, ID> {


    @Override
    public T Insert(T v) {

        System.out.println("inserting ....... to space " + v);
        return v;
    }

    @Override
    public T read(ID id) {

        System.out.println("trying to read data: " + id + " from space");

        T t = null;
        return t;
    }

    @Override
    public T[] readAll() {

        return null;

    }
}
