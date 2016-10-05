package se.java.serializable.jackson;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class TestJSONSubclassing {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        ClientObject c = new ClientObject();


        MyItem i1 = new MySubItemA(1, "Value1", "Some stuff", "Another property value");
        MyItem i2 = new MySubItemB(2, "Value2", 1000, "B property");
        MyItem i3 = new MySubItemC(3, "Value3", 2000, -1);
        MyItem i4 = new MySubItemA(4, "Value4", "Bla Bla Bla", "item A property");

        c.getL().add(i1);
        c.getL().add(i2);
        c.getL().add(i3);
        c.getL().add(i4);

        String s = null;
        try {
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            s = mapper.writeValueAsString(c);
        }
        catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(s);


        ClientObject c2 = null;
        try {
            c2 = mapper.readValue(s, ClientObject.class);
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (c2 != null) {
            System.out.println("----- Items List -----");

            for (MyItem mi : c2.getL())
                System.out.println("Type = " + mi.getClass() +  ", id = "+ mi.getId() + ", name = " + mi.getName());
        }

    }
}