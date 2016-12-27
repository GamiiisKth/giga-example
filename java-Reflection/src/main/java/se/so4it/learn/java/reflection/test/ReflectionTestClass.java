package se.so4it.learn.java.reflection.test;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@konsult.folksam.se/>}
 */
public class ReflectionTestClass {

    public String name;

    private int age;

    public ReflectionTestClass() {
    }

    public ReflectionTestClass(int age) {
        this.age = age;
    }

    public ReflectionTestClass(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReflectionTestClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
