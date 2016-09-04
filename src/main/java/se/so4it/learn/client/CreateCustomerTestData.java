package se.so4it.learn.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import se.so4it.learn.domain.Customer;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class CreateCustomerTestData {

    ClientService clientService;

    public CreateCustomerTestData() {
        System.out.println();
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("CustomerService.xml");

        ClientService service = (ClientService) context.getBean("service");
        service.createCustomer(Customer.builder().withName("ali").build());

        service.getCustomer("1");
    }

}
