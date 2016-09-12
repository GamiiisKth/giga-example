package se.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class GenericTest {

    private static List<GerericA> gerericAs = new ArrayList<>();
    private static List<GenericB> genericBs = new ArrayList<>();
    private static List<GenericC> genericCs = new ArrayList<>();


    public static void main(String[] args) {
        GenericTest genericTest = new GenericTest();


        genericTest.init(gerericAs);
        genericTest.processElements(gerericAs);

    }

    private void init(List<? super GerericA> gerericAs) {
        int listLenght = GerericA.JACKPOT_IDS.length;

        while (listLenght > 0) {
            gerericAs.add(GerericA.JACKPOT_IDS[listLenght & 7]);
            listLenght--;
        }
    }

    public void processElements(List<? extends GerericA> elements) {
        elements.forEach(System.out::println);

    }
}



