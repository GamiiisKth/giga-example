package se.so4it.learn.dao; /**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */

import se.so4it.learn.common.GenericDao;
import se.so4it.learn.entity.CustomerEntity;

/**
 * by creating a instance of this interface you will be able to have access to all the
 * method in se.so4it.learn.common.GenericDao
 *
 * typically the serviceImpl class will create a instance of this interface
 */
public interface CustomerEntityDao extends GenericDao<CustomerEntity,String> {

}
