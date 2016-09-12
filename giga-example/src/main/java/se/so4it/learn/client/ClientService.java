package se.so4it.learn.client;

import se.so4it.learn.domain.Customer;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public interface ClientService {


    public void createCustomer(Customer customer);
    public Customer getCustomer(String id);

}
