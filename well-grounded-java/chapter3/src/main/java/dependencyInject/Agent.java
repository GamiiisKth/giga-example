package dependencyInject;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class Agent {

    private String firstName;
    private String lastName;

    private int rate;

    public Agent(String firstName, String lastName, int rate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rate = rate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

}
