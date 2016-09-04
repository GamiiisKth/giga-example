package se.so4it.learn.domainMapper;

import se.so4it.learn.domain.CreateCustomerRequest;
import se.so4it.learn.domain.Customer;
import se.so4it.learn.entity.CustomerEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class CustomerMapper {

    /**
     * @param customerEntity will be returned from space
     *                       and which map will convert it to Customer object
     * @return
     */
    public static Customer map(CustomerEntity customerEntity) {

        if (customerEntity == null) {
            return null;
        }
        return Customer.builder()
                .withId(customerEntity.getId())
                .withName(customerEntity.getName())
                .build();
    }

    public static CustomerEntity map(CreateCustomerRequest createCustomerRequest) {
        if (createCustomerRequest == null) {
            return null;
        }
        return CustomerEntity.builder()
                .withName(createCustomerRequest.getName())
                .build();
    }

    public static Set<Customer> map(CustomerEntity[] customerEntities) {
        if (customerEntities == null) {
            return null;
        }
        Set<Customer> customers = new HashSet<>();
        for (CustomerEntity customerEntity : customerEntities) {
            customers.add(map(customerEntity));
        }
        return customers;
    }
}
