package se.so4it.learn.client;

import se.so4it.learn.domain.CreateCustomerRequest;
import se.so4it.learn.domain.Customer;
import se.so4it.learn.service.CustomerService;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class ClientCustomerImp implements ClientService {

    private CustomerService customerService;

    public ClientCustomerImp(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void createCustomer(Customer customer) {

        customerService.createCustomer(CreateCustomerRequest.builder()
                .withName(customer.getName()).build()
        );
    }

    @Override
    public Customer getCustomer(String id) {
        return null;
    }
}
