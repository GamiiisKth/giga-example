package se.java.serializable.jackson.javaserlizable;

import java.io.*;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class JavaSerializable implements Serializable {

    private static final String SERIALIZABLE_FILE = "serializable.ser";
    public static final Long serialVersionUID = 1L;

    private String name;
    private int rid;

    // stop the field to become serialized
    private transient String constant;

    public JavaSerializable(String name, int rid, String constant) {
        this.name = name;
        this.rid = rid;
        this.constant = constant;
    }

    @Override
    public String toString() {
        return "JavaSerializable{" +
                "name='" + name + '\'' +
                ", rid=" + rid +
                ", constant='" + constant + '\'' +
                '}';
    }

    private static class serializableTest {
        public static void main(String[] args) {

            JavaSerializable serializable = new JavaSerializable("ali", 1, "doCanNotSerializable");

            try {
                FileOutputStream outputStream = new FileOutputStream(SERIALIZABLE_FILE);
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    objectOutputStream.writeObject(serializable);
                    objectOutputStream.close();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
    }

    private static class DeserializationTest {

        public static void main(String[] args) throws ClassNotFoundException {
            JavaSerializable javaSerializable;

            try {
                FileInputStream fis = new FileInputStream(SERIALIZABLE_FILE);
                try {
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    javaSerializable = (JavaSerializable) ois.readObject();

                    System.out.println(javaSerializable);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
    }
}
