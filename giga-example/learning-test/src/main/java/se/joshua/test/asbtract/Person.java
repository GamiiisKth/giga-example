package se.joshua.test.asbtract;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@konsult.folksam.se/>}
 */
public class Person {

    private String firstName;
    private String lastName;
    private String id;


    public Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.id = builder.id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder {
        private String firstName;
        private String lastName;
        private String id;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
