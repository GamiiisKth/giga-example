package se.so4it.learn.entity;

import se.so4it.learn.common.IdEntity;

import java.util.Objects;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         this class should i reeal implmentation have spaceId notation
 *         and spaceClass which help to hide the implmentation of gigaspaces and gridgain
 *
 *         and remember the space will return the same class from space ? maybe
 */

//@SpaceClass
public final class CustomerEntity extends IdEntity<String> {


    private String id;

    private String name;


    private CustomerEntity(Builder builder) {

        this.id = builder.id;
        this.name = builder.name;
    }

    @Override
    //@SpaceId
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Builder builder() {
        return new Builder();
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

        public CustomerEntity build() {
            return new CustomerEntity(this);
        }

    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

