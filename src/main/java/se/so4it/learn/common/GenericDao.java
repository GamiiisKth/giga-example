package se.so4it.learn.common; /**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */

/**
 * @param <T>  The T class must have extended se.so4it.learn.common.IdEntity
 * @param <ID> because se.so4it.learn.common.IdEntity have even <T> param
 *             <p>
 *             example se.so4it.learn.dao.CustomerEntityDao extends se.so4it.learn.common.GenericDao<se.so4it.learn.entity.CustomerEntity,String>
 *             and
 *             se.so4it.learn.entity.CustomerEntity extends se.so4it.learn.common.IdEntity<String>
 *             <p>
 *             The important is the class which implement se.so4it.learn.dao.CustomerEntityDao  have access to all method
 *             which is declared in this interface 'se the se.so4it.learn.serviceImpl.ServiceImpl'
 */
public interface GenericDao<T extends IdEntity, ID> {

    T Insert(T v);

    /**
     * @param id The ID class in this case will become String because the customer class has implement se.so4it.learn.common.IdEntity<String>
     * @return se.so4it.learn.entity.CustomerEntity
     *
     * value will in this case become se.so4it.learn.entity.CustomerEntity because the  se.so4it.learn.dao.CustomerEntityDao extends se.so4it.learn.common.GenericDao<se.so4it.learn.entity.CustomerEntity,String>
     */
    T read(ID id);
}
