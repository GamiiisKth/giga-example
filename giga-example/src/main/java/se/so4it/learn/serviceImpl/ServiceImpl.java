package se.so4it.learn.serviceImpl; /**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */

import se.so4it.learn.dao.CustomerEntityDao;
import se.so4it.learn.domain.CreateCustomerRequest;
import se.so4it.learn.domain.Customer;
import se.so4it.learn.domainMapper.CustomerMapper;
import se.so4it.learn.service.CustomerService;

import java.util.Set;

/**
 * this class should implement the service interface which the only way
 * for client to trigger CRUD operation
 */
public class ServiceImpl implements CustomerService {

    CustomerEntityDao customerEntityDao;

    public ServiceImpl(CustomerEntityDao customerEntityDao) {
        this.customerEntityDao = customerEntityDao;
    }

    /**
     * @param id
     * @return se.so4it.learn.entity.CustomerEntity which return
     */
    public Customer getCustomer(String id) {
        // customerEntityDao will return CustomerEntity and map
        // wil map/customer it to customer
        return CustomerMapper.map(customerEntityDao.read(id));
    }

    public void createCustomer(CreateCustomerRequest customerRequest) {
        // CustomerMapper will map/convert a customerRequest to a customerEntity
        // then a customerEntity wil be inserted to space
        customerEntityDao.Insert(CustomerMapper.map(customerRequest));
    }

    public Set<Customer> getCustomers() {
        // same operation as getCustomer but CustomerMapper will instead return
        // a set of customers
        return CustomerMapper.map(customerEntityDao.readAll());
    }
}
