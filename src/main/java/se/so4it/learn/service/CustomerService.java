package se.so4it.learn.service;

import se.so4it.learn.domain.Customer;

import java.util.Set;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *
 * this is interface typically called from client side wich has implementation on serviceImpl
 *
 */
public interface CustomerService {


    Customer getCustomer(String id);

    void createCustomer(Customer customer);

    Set<Customer> getCustomers();
}
