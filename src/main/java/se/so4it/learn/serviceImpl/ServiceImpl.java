package se.so4it.learn.serviceImpl; /**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */

import se.so4it.learn.dao.CustomerEntityDao;
import se.so4it.learn.domain.Customer;
import se.so4it.learn.entity.CustomerEntity;
import se.so4it.learn.service.CustomerService;

import java.util.Set;

/**
 * this class should implement the service interface which the only way
 * for client to trigger CRUD operation
 */
public class ServiceImpl implements CustomerService {


    CustomerEntityDao customerEntityDao;

    /**
     * @param id
     * @return se.so4it.learn.entity.CustomerEntity which return
     * <p>
     * TODO start here, we should return a customer instead  se.so4it.learn.entity.CustomerEntity, solution implement a mapper
     * and create a service interface With the crud method to be implemented here
     */

    @Override
    public Customer getCustomer(String id) {
        return null;
    }

    @Override
    public void createCustomer(Customer customer) {

    }

    @Override
    public Set<Customer> getCustomers() {
        return null;
    }
}
