package se.so4it.learn.domain;

import se.so4it.learn.common.IdEntity;

import java.util.Objects;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class Customer extends IdEntity<String> {

    private String name;
    private String id;


    private Customer(Builder builder) {

        this.id = Objects.requireNonNull(builder.id, String.format(id, " can't be null"));
        this.name = Objects.requireNonNull(builder.name, String.format(name, " can't be null"));
    }

    public Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public static class Builder {
        private String id;
        private String name;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }

    }

}
