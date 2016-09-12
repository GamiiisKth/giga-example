package se.so4it.learn.domain;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         difference between this class and customer is this class have'nt any Customer Id
 */
public class CreateCustomerRequest {

    private String name;


    public CreateCustomerRequest() {
    }

    private CreateCustomerRequest(Builder builder) {
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public CreateCustomerRequest build() {
            return new CreateCustomerRequest(this);
        }
    }

}
